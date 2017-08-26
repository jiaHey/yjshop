package com.shop;

import com.shop.common.utils.PageUtil;
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
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
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
    }

    @Test
    public void findFirst() {
        cartRepository.findFirstByGoodsIdAndUserId(1L, 2L);
    }

    @Test
    public void addCartGoods() {
        Goods g = goodsService.findById(5L);
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
    }

    @Test
    public void findUserCart() {
        User user = userService.loginWx();
        cartRepository.findAllByUserEquals(user);
    }

    @Test
    public void updateUserCart() {
        HashSet<Cart> carts = new HashSet<Cart>();
        Cart cart = new Cart();
        cart.setNumber(1);
        cart.setGoods(goodsService.findById(5L));
        carts.add(cart);
        User user = userService.loginWx();
        user.setCart(carts);
        userService.save(user);
    }
}
