package com.shop.modules.shop.service;

import com.shop.modules.shop.dao.UserCouponRepository;
import com.shop.modules.shop.domain.Coupon;
import com.shop.modules.shop.domain.User;
import com.shop.modules.shop.domain.UserCoupon;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by heyujia on 2017/12/7.
 */
@Service
public class UserCouponService {

    @Autowired
    private UserCouponRepository userCouponRepository;

    public List<UserCoupon> findUserCouponByUserId(Long uid) {
        return userCouponRepository.findUserCouponByUserId(uid);
    }

    public List<UserCoupon> findUseFulUserCouponByUserId(Long uid) {
        return userCouponRepository.findUseFulUserCouponByUserId(uid, new Date());
    }

    public void consumeUserCoupon(User user, Coupon coupon) {

    }
}
