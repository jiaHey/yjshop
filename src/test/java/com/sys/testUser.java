package com.sys;

import com.shop.Application;
import com.shop.modules.sys.domain.SysRole;
import com.shop.modules.sys.domain.SysUser;
import com.shop.modules.sys.service.SysRoleService;
import com.shop.modules.sys.service.SysUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.ExampleMatcher;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class testUser {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;

    @Test
    public void example() {
        SysUser user = sysUserService.findOne(1L);
        HashSet<Long> roleIds = new HashSet<Long>();
        roleIds.add(1L);
        roleIds.add(2L);
        List<SysRole> roles = sysRoleService.findAll(roleIds);
        user.setSysRoles(new HashSet<SysRole>(roles));
        sysUserService.save(user);
    }
}
