package com.sys;

import com.shop.Application;
import com.shop.common.utils.Constant;
import com.shop.modules.sys.dao.SysMenuRepository;
import com.shop.modules.sys.service.SysMenuService;
import org.apache.commons.lang3.StringUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class testPerm {
    @Autowired
    private SysMenuService sysMenuService;

    @Autowired
    private SysMenuRepository sysMenuRepository;
    @Test
    public void perm() {
        sysMenuRepository.findPermsByUserId(15L);
    }
}
