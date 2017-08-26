package com.shop.modules.shop.controller.home;

import com.shop.common.utils.PageUtil;
import com.shop.common.utils.R;
import com.shop.modules.shop.domain.Cart;
import com.shop.modules.shop.domain.Goods;
import com.shop.modules.shop.domain.User;
import com.shop.modules.shop.service.CartService;
import com.shop.modules.shop.service.GoodsService;
import com.shop.modules.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/home/cart")
public class CartHomeController {

    @Autowired
    private CartService cartService;
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private UserService userService;

    @RequestMapping("cartGoodsList")
    public R cartGoodsList() {
        User user = userService.loginWx();
        List<Cart> cart = cartService.findCartByUserId(user.getId());
        return R.ok().put("cart", cart);
    }

    @RequestMapping("cartGoodsAdd")
    public R cartGoodsAdd(Long id) {
        User user = userService.loginWx();
        Goods goods = goodsService.findOne(id);
        cartService.addCartGoods(user, goods);
        return R.ok();
    }

    @RequestMapping("cartGoodsEdit")
    public R cartGoodsEdit(@RequestBody List<Cart> cartList) {
        User user = userService.loginWx();
        cartService.deleteByUserEquals(user);
        HashSet<Cart> cartSet = new HashSet<Cart>();
        for (Cart cart : cartList) {
            Goods goods = goodsService.findOne(cart.getGoods().getId());
            Cart cartItem = new Cart();
            cartItem.setGoods(goods);
            cartItem.setUser(user);
            cartItem.setNumber(cart.getNumber());
            cartSet.add(cartItem);
        }
        user.setCart(cartSet);
        userService.save(user);
        return R.ok();
    }

    @RequestMapping("cartGoodsDelete")
    public R cartGoodsDelete(Long id) {
        cartService.delete(id);
        return R.ok();
    }

    @RequestMapping("cartGoodsClear")
    public R cartGoodsClear() {
        User user = userService.loginWx();
        cartService.deleteByUserEquals(user);
        return R.ok();
    }
}
