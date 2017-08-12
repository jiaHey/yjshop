package com.shop.modules.shop.dao;

import com.shop.modules.shop.domain.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepository extends JpaRepository<User,Long> {

    public User findByOpenidEquals(String openid);
    @Query("select u from User u where u.nickname like CONCAT('%',:text,'%')")
    Page<User> findFullText(@Param("text") String keyword, Pageable page);
}