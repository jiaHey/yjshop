package com.shop;

import com.shop.modules.shop.dao.UserRepository;
import com.shop.modules.shop.domain.User;
import com.shop.modules.shop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class testUser {
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;
    @Test
    public void testSave(){
        User user = new User();
        user.setNickname("asd");
    }

    @Test
    public void cartGoods(){
    }
}
