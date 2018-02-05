package com.sys;

import com.shop.Application;
import com.shop.modules.sys.dao.SysMenuRepository;
import com.shop.modules.sys.domain.SysMenu;
import com.shop.modules.sys.service.ShiroService;
import com.shop.modules.sys.service.SysMenuService;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.annotation.Resource;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class testMenu {
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private SysMenuRepository sysMenuRepository;
    @Autowired
    private ShiroService shiroService;
    @PersistenceContext
    private EntityManager entityManager;

    @Test
    public void permissions() {
        List<SysMenu> notButtonList = sysMenuService.findMenuList();
        entityManager.clear();
        System.out.println("as");
    }

    @Test
    public void testMenu() {
    }
}
