package com.shop.modules.shop.dao;

import com.shop.modules.shop.domain.Goods;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Set;

public interface GoodsRepository extends JpaRepository<Goods,Long>,JpaSpecificationExecutor {

    @Query(value = "select g from Goods g join g.tags t where t.id in (:ids)")
    public List<Goods> findGoodsByTagsId(@Param("ids") Set<Long> ids);

    @EntityGraph(value = "Goods.detail", type = EntityGraph.EntityGraphType.LOAD)
    public Goods findDetailById(Long id);

    @Query("select g from Goods g where g.title like CONCAT('%',:text,'%')")
    Page<Goods> findFullText(@Param("text") String text, Pageable pageable);
}
