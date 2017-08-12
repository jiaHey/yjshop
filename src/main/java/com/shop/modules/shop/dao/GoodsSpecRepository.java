package com.shop.modules.shop.dao;

import com.shop.modules.shop.domain.GoodsSpec;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsSpecRepository extends JpaRepository<GoodsSpec,Long> {

    @Query("select gs from GoodsSpec gs where gs.goods.id = :id")
    public List<GoodsSpec> findByGoodsId(@Param("id") Long id);

}
