package com.sys;

import com.shop.Application;
import com.shop.modules.sys.dao.SysConfigRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class testConfig {
    @Autowired
    private SysConfigRepository sysConfigRepository;
    @Test
    public void search(){
//        PageRequest pageable = new PageRequest(1, 2);
//
//        sysConfigRepository.findFullText("a",pageable);

    }
}
