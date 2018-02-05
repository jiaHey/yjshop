package com.shop.modules.shop.dao;

import com.shop.modules.shop.domain.Coupon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface CouponRepository extends JpaRepository<Coupon, Long> {

    @Query("select c from Coupon c where c.title like CONCAT('%',:text,'%')")
    Page<Coupon> findFullText(@Param("text") String text, Pageable pageable);
}