package com.shop.modules.shop.service;

import com.shop.common.exception.RRException;
import com.shop.modules.shop.dao.UserRepository;
import com.shop.modules.shop.domain.User;
import com.shop.modules.sys.domain.SysConfig;
import com.shop.modules.sys.service.SysConfigService;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private HttpSession session;
    @Autowired
    private HttpServletResponse response;
    @Autowired
    private SysConfigService sysConfigService;

    public User loginWx() {
        User user;
        user = (User) session.getAttribute("user");
        if(user!=null) return user;

        SysConfig appid = sysConfigService.findByNameEquals("appid");
        SysConfig secret = sysConfigService.findByNameEquals("secret");
        if(appid==null||secret==null){
            throw new RRException("公众号配置错误");
        }
        WxMpInMemoryConfigStorage config = new WxMpInMemoryConfigStorage();
        config.setAppId(appid.getValue()); // 设置微信公众号的appid
        config.setSecret(secret.getValue()); // 设置微信公众号的app corpSecret
        WxMpService wxService = new WxMpServiceImpl();
        wxService.setWxMpConfigStorage(config);

        String code = request.getParameter("code");
        if (code == null) {
            //跳转
            String url = request.getRequestURL().toString();
            String loc = wxService.oauth2buildAuthorizationUrl(url, "snsapi_base", "");
            try {
                response.sendRedirect(response.encodeRedirectURL(loc));
                return null;
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        WxMpOAuth2AccessToken wxMpOAuth2AccessToken = null;
        WxMpUser wxMpUser = null;
        try {
            wxMpOAuth2AccessToken = wxService.oauth2getAccessToken(code);
            wxMpUser = wxService.oauth2getUserInfo(wxMpOAuth2AccessToken, null);
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        user = userRepository.findByOpenidEquals(wxMpUser.getOpenId());
        if (user == null) {
            user = new User(wxMpUser);
            user.setCreated(new Date());
            save(user);
        }
        session.setAttribute("user",user);
        return user;
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public User findById(Long id) {
        return userRepository.findOne(id);
    }

    public Page<User> findFullText(String keyword, PageRequest page) {
       return userRepository.findFullText(keyword,page);
    }
}
