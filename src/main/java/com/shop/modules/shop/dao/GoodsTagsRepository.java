package com.shop.modules.shop.dao;

import com.shop.modules.shop.domain.GoodsTags;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GoodsTagsRepository extends JpaRepository<GoodsTags,Long> {
    @EntityGraph(value = "goods", type = EntityGraph.EntityGraphType.LOAD)
    public List<GoodsTags> findAllByIdAfter(Long id);

    @Query("select t from GoodsTags t where t.title like CONCAT('%',:text,'%')")
    Page<GoodsTags> findFullText(@Param("text") String text, Pageable page);

    public List<GoodsTags> findByIsShowEquals(Boolean isShow);
}