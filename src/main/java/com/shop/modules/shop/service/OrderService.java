package com.shop.modules.shop.service;

import com.shop.modules.shop.dao.CartRepository;
import com.shop.modules.shop.dao.OrderRepository;
import com.shop.modules.shop.domain.*;
import com.shop.common.utils.UtilOrder;
import com.shop.modules.shop.domain.enums.OrderStatus;
import org.aspectj.weaver.ast.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.*;

@Service
public class OrderService {
    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private CartService cartService;
    @Autowired
    private CartRepository cartRepository;

    public Order findDetailById(Long id) {
        return orderRepository.findByIdIs(id);
    }

    @Transactional
    public Order createOrder(User user, Address address) {
        Order order = new Order();
        order.setNumber(UtilOrder.genOrderNum());
        order.setStatus(OrderStatus.UNPAID);
        order.setUser(user);
        List<Cart> carts = cartRepository.findAllByUserEquals(user);
        Iterator<Cart> iterator = carts.iterator();
        Set<OrderGoods> orderGoodsSet = new HashSet<OrderGoods>();
        BigDecimal priceTotal = new BigDecimal(0);
        while (iterator.hasNext()) {
            Cart cart = iterator.next();
            //orderGoods
            Goods goods = cart.getGoods();
            OrderGoods orderGoods = new OrderGoods(goods);
            orderGoods.setGoodsNum(cart.getNumber());
            BigDecimal priceOrderGoods = goods.getPrice().multiply(new BigDecimal(cart.getNumber()));
            orderGoods.setGoodsPrice(priceOrderGoods);
            orderGoodsSet.add(orderGoods);
            priceTotal = priceTotal.add(priceOrderGoods);
        }
        order.setOrderGoods(orderGoodsSet);
        order.setPrice(priceTotal);
        order.setAddressStr(address.getArea() + "" + address.getAddress());
        cartService.deleteByUserEquals(user);
        return orderRepository.save(order);
    }

    public Order save(Order order) {
        order.setUpdated(new Date());
        return orderRepository.save(order);
    }

    public Page<Order> findFullText(String keyword, PageRequest page) {
        return orderRepository.findFullText(keyword, page);
    }

    public Page<Order> findAllByUserEquals(User user, Pageable pageable) {
        return orderRepository.findAllByUserEquals(user, pageable);
    }
    public Page<Order> findDetailByUserEquals(User user, Pageable pageable){
        return orderRepository.findDetailByUserEquals(user, pageable);
    }

    public void delete(Long id) {
        orderRepository.delete(id);
    }

    public Order findOne(Long id) {
        return orderRepository.findOne(id);
    }
}
