package com.shop;

import com.shop.modules.shop.dao.OrderRepository;
import com.shop.modules.shop.domain.Address;
import com.shop.modules.shop.domain.User;
import com.shop.modules.shop.service.AddressService;
import com.shop.modules.shop.service.OrderService;
import com.shop.modules.shop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashSet;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class testOrder {
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderService orderService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private UserService userService;
    @Test
    public void pageUser(){
        PageRequest pageable = new PageRequest(1, 10, new Sort(Sort.Direction.DESC, "id"));
        orderRepository.pageByUserId(1L, pageable);
    }
    @Test
    public void findById(){
        orderRepository.findByIdIs(1L);
    }
    @Test
    public void newOrder(){
        User us = userService.findById(1L);
        Address address = addressService.findDefaultAddress(us.getId());
        HashSet<Long> ids = new HashSet<Long>();
        ids.add(1L);
        ids.add(2L);
        orderService.newOrder(us,ids,address);
    }
}
