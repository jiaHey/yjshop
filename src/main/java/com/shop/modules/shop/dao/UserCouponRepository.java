package com.shop.modules.shop.dao;

import com.shop.modules.shop.domain.Coupon;
import com.shop.modules.shop.domain.User;
import com.shop.modules.shop.domain.UserCoupon;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

/**
 * Created by heyujia on 2017/12/7.
 */
public interface UserCouponRepository extends JpaRepository<UserCoupon, Long> {
    @Query("select uc from UserCoupon uc where uc.user.id = :uid")
    @EntityGraph(value = "UserCoupon.couponPromote", type = EntityGraph.EntityGraphType.LOAD)
    public List<UserCoupon> findUserCouponByUserId(@Param("uid") Long uid);

    @Query("select uc from UserCoupon uc where uc.user.id = :uid and uc.used is null " +
            "and :date between uc.begin and uc.end")
    @EntityGraph(value = "UserCoupon.couponPromote", type = EntityGraph.EntityGraphType.LOAD)
    public List<UserCoupon> findUseFulUserCouponByUserId(@Param("uid") Long uid, @Param("date") Date date);

    public UserCoupon findUserCouponByCouponEqualsAndUserEquals(Coupon coupon,User user);

}
