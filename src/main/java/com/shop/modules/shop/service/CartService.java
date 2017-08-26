package com.shop.modules.shop.service;

import com.shop.modules.shop.dao.CartRepository;
import com.shop.modules.shop.domain.Cart;
import com.shop.modules.shop.domain.Goods;
import com.shop.modules.shop.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class CartService {

    @Autowired
    private CartRepository cartRepository;


    public List<Cart> findCartByUserId(Long uid) {
        return cartRepository.findCartByUserId(uid);
    }

    /**
     * 新增或加数量
     *
     * @param user  用户
     * @param goods 商品
     */
    public Cart addCartGoods(User user, Goods goods) {
        Cart cart = cartRepository.findFirstByGoodsIdAndUserId(goods.getId(), user.getId());
        if (cart == null) {
            cart = new Cart();
            cart.setUser(user);
            cart.setGoods(goods);
            cart.setNumber(1);
        } else {
            cart.setNumber(cart.getNumber() + 1);
        }
        return cartRepository.save(cart);
    }

    @Transactional
    public void deleteCartGoods(Long cid) {
        cartRepository.delete(cid);
    }

    @Transactional
    public Integer cleanCartGoods(Long uid) {
        return cartRepository.deleteByUserId(uid);
    }

    public Cart save(Cart cart) {
        return cartRepository.save(cart);
    }

    public void delete(Long id) {
        cartRepository.delete(id);
    }

    public Cart findByIdEquals(Long id) {
        return cartRepository.findByIdEquals(id);
    }

    @Transactional
    public void deleteByUserEquals(User user) {
        cartRepository.deleteByUserEquals(user);
    }
}
