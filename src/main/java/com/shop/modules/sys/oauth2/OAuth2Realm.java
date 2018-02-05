package com.shop.modules.sys.oauth2;

import com.shop.modules.shop.domain.User;
import com.shop.modules.sys.domain.SysUser;
import com.shop.modules.sys.service.ShiroService;
import com.shop.modules.sys.service.SysUserService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

import static org.apache.shiro.web.filter.mgt.DefaultFilter.user;

/**
 * 认证
 */
@Component
public class OAuth2Realm extends AuthorizingRealm {

    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private ShiroService shiroService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof OAuth2Token;
    }

    /**
     * 授权(验证权限时调用)
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SysUser user = (SysUser) principals.getPrimaryPrincipal();
        //用户权限列表

        Set<String> permsSet = shiroService.getUserPermissions(user.getId());
        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        info.setStringPermissions(permsSet);

        return info;
    }

    /**
     * 认证(登录时调用)
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        String accessToken = (String) token.getPrincipal();
        Jws<Claims> auth = Jwts.parser().setSigningKey(SysUser.SIGNKEY).parseClaimsJws(accessToken);
        String id = auth.getBody().getId();
        SysUser user = sysUserService.findOne(Long.parseLong(id));
        SimpleAuthenticationInfo info = new SimpleAuthenticationInfo(user, accessToken, getName());
        return info;
    }
}
