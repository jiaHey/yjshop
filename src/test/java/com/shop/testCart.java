package com.shop;

import com.shop.modules.shop.dao.CartRepository;
import com.shop.modules.shop.domain.Cart;
import com.shop.modules.shop.domain.Goods;
import com.shop.modules.shop.domain.User;
import com.shop.modules.shop.service.CartService;
import com.shop.modules.shop.service.GoodsService;
import com.shop.modules.shop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashSet;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class testCart {

    @Autowired
    private CartRepository cartRepository;

    @Autowired
    private UserService userService;
    @Autowired
    private GoodsService goodsService;

    @Autowired
    private CartService cartService;

    @Test
    public void cartGoods() {
        List<Cart> carts = cartRepository.findCartByUserId(1L);
        for (Cart c :
                carts) {
            System.out.println(c.getGoods());
        }
    }

    @Test
    public void findFirst() {
        cartRepository.findFirstByGoodsIdAndUserId(1L, 2L);
    }

    @Test
    public void addCartGoods() {
        Goods g = goodsService.findById(1L);
        User u = userService.findById(1L);
        cartService.addCartGoods(u, g);
    }

    @Test
    public void clean() {
        cartService.deleteCartGoods(1L);
//        cartService.cleanCartGoods(2L);
    }

    @Test
    public void findCardIds() {
        HashSet<Long> longs = new HashSet<Long>();
        cartRepository.findCartByIdIn(longs);
    }
}
