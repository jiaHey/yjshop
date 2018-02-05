package com.promote;

import com.shop.Application;
import com.shop.modules.shop.dao.UserCouponRepository;
import com.shop.modules.shop.domain.Coupon;
import com.shop.modules.shop.domain.User;
import com.shop.modules.shop.domain.UserCoupon;
import com.shop.modules.shop.service.CartService;
import com.shop.modules.shop.service.CouponService;
import com.shop.modules.shop.service.UserCouponService;
import com.shop.modules.shop.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import sun.management.FileSystem;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;


/**
 * Created by heyujia on 2017/11/24.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class testPromote {

    @Autowired
    private UserCouponService userCouponService;
    @Autowired
    private UserService userService;
    @Autowired
    private CartService cartService;
    @Autowired
    private CouponService couponService;
    @Autowired
    private UserCouponRepository userCouponRepository;
    @Test
    public void test(){
        User user = userService.loginWx();
        Coupon bestCoupon = couponService.getBestCoupon(user, cartService.findCartByUserId(user.getId()));
        UserCoupon userCoupon = userCouponRepository.findUserCouponByCouponEqualsAndUserEquals(bestCoupon, user);

    }

}
