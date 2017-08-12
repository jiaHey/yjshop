package com.shop.modules.sys.dao;

import com.shop.modules.shop.domain.Cart;
import com.shop.modules.sys.domain.SysConfig;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface SysConfigRepository extends JpaRepository<SysConfig, Long> {
    @Query("select c from SysConfig c where c.name like CONCAT('%',:text,'%')")
    Page<SysConfig> findFullText(@Param("text") String text,Pageable page);

    SysConfig findByNameEquals(String name);
}