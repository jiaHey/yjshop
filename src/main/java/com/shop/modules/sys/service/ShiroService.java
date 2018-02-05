package com.shop.modules.sys.service;

import com.shop.common.utils.Constant;
import com.shop.modules.sys.dao.SysMenuRepository;
import com.shop.modules.sys.dao.SysUserRepository;
import com.shop.modules.sys.domain.SysMenu;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ShiroService {
    @Autowired
    private SysMenuService sysMenuService;

    public Set<String> getUserPermissions(long userId) {
        List<String> permsList;
        //系统管理员，拥有最高权限
        if (userId == Constant.SUPER_ADMIN) {
            permsList = sysMenuService.findPermsAll();
        } else {
            permsList = sysMenuService.findPermsByUserId(userId);
        }
        //        //用户权限列表
        Set<String> permsSet = new HashSet<String>();
        for (String perms : permsList) {
            if (StringUtils.isBlank(perms)) {
                continue;
            }
            permsSet.addAll(Arrays.asList(perms.trim().split(",")));
        }
        return permsSet;
    }

}
