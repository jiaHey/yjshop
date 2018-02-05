package com.shop.modules.shop.service;

import com.shop.modules.shop.dao.CouponRepository;
import com.shop.modules.shop.domain.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by heyujia on 2017/11/24.
 */
@Service
public class CouponService {

    @Autowired
    private PromoteService promoteService;
    @Autowired
    private UserCouponService userCouponService;
    @Autowired
    private CouponRepository couponRepository;

    public Page<Coupon> findFullText(String text, Pageable pageable) {
        return couponRepository.findFullText(text, pageable);
    }

    public Coupon findOne(Long id) {
        return couponRepository.findOne(id);
    }

    public Coupon save(Coupon coupon) {
        return couponRepository.save(coupon);
    }

    public void delete(Long id) {
        couponRepository.delete(id);
    }

    public void deleteBatch(Long[] couponIds) {
        ArrayList<Coupon> couponArrayList = new ArrayList<Coupon>();
        Coupon coupon;
        for (Long id : couponIds) {
            coupon = new Coupon();
            coupon.setId(id);
            couponArrayList.add(coupon);
        }
        couponRepository.deleteInBatch(couponArrayList);
    }

    /**
     * 获取最优惠的优惠券
     */
    public Coupon getBestCoupon(User user, List<Cart> cartList) {
        List<UserCoupon> userCouponList = userCouponService.findUseFulUserCouponByUserId(user.getId());
        BigDecimal minPrice = new BigDecimal(Integer.MAX_VALUE);
        Coupon coupon = null;
        for (UserCoupon userCoupon : userCouponList) {
            BigDecimal price = promoteService.getPromotePrice(userCoupon.getPromote(), cartList);
            if (price != null && price.compareTo(minPrice) < 0) {
                coupon = userCoupon.getCoupon();
            }
        }
        return coupon;
    }

    /**
     * 使用优惠券后的价格
     *
     * @return
     */
    public BigDecimal getCouponPrice(Coupon coupon, Iterable<Cart> cartList) {
        return promoteService.getPromotePrice(coupon.getPromote(), cartList);
    }

    public void consumeCoupon(User user, Coupon coupon) {
        userCouponService.consumeUserCoupon(user, coupon);
    }


}
