package com.sys;

import com.shop.Application;
import com.shop.modules.sys.domain.SysUser;
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

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class testUser {
    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private EntityManager entityManager;
    @Test
    @Transactional
    public void example(){
        SysUser one = sysUserService.findOne(1L);
//        System.out.println(entityManager.contains(one));
//        System.out.println(entityManager.contains(one));

    }
}
