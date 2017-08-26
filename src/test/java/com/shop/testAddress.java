package com.shop;


import com.shop.modules.shop.dao.AddressRepository;
import com.shop.modules.shop.domain.User;
import com.shop.modules.shop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class testAddress {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private UserService userService;
    @Test
    @Transactional
    public void updateNoDefault(){
        User user = userService.loginWx();
        addressRepository.updateNoDefault(1L);

    }
}
