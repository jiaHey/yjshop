package com.shop.modules.shop.service;

import com.shop.modules.shop.dao.CartRepository;
import com.shop.modules.shop.dao.OrderRepository;
import com.shop.modules.shop.domain.*;
import com.shop.common.utils.UtilOrder;
import com.shop.modules.shop.domain.enums.OrderStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
    private CartRepository cartRepository;

    public Page<Order> pageNew(Integer page) {
        PageRequest pageable = new PageRequest(page, 10, new Sort(Sort.Direction.DESC, "id"));
        return orderRepository.findAll(pageable);
    }

    public Page<Order> pageNewByUserId(Long uid, Integer page) {
        PageRequest pageable = new PageRequest(page, 10, new Sort(Sort.Direction.DESC, "id"));
        return orderRepository.pageByUserId(uid, pageable);
    }

    public Order findDetailById(Long id) {
        return orderRepository.findByIdIs(id);
    }

    @Transactional
    public Order newOrder(User user, Set<Long> ids, Address address) {
        Order order = new Order();
        order.setNumber(UtilOrder.genOrderNum());
        order.setStatus(OrderStatus.UNPAID);
        order.setUser(user);
        List<Cart> carts = cartRepository.findCartByIdIn(ids);
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
        order.setAddress(address);
        order.setAddressStr(address.getArea() + address.getAddress());
//        cartRepository.deleteByIdIn(ids);
        return orderRepository.save(order);
    }

    public Order save(Order order) {
        order.setUpdated(new Date());
        return orderRepository.save(order);
    }

    public Page<Order> findFullText(String keyword, PageRequest page) {
        return  orderRepository.findFullText(keyword,page);
    }


    public void delete(Long id) {
        orderRepository.delete(id);
    }
}
