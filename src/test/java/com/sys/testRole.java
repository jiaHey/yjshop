package com.sys;

import com.shop.Application;
import com.shop.modules.sys.domain.SysMenu;
import com.shop.modules.sys.domain.SysRole;
import com.shop.modules.sys.service.SysMenuService;
import com.shop.modules.sys.service.SysRoleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashSet;
import java.util.List;

/**
 * Created by heyujia on 2017/9/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class testRole {

    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private SysMenuService sysMenuService;

    @Test
    public void role(){
        SysRole sysRole = sysRoleService.findOne(8L);
        HashSet<Long> menuIds = new HashSet<Long>();
        menuIds.add(1L);
        menuIds.add(2L);
        menuIds.add(3L);
        List<SysMenu> menuList = sysMenuService.findAll(menuIds);
        sysRole.setSysMenus(new HashSet<SysMenu>(menuList));
        sysRoleService.save(sysRole);
    }
}
