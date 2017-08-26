package com.shop.modules.shop.dao;

import com.shop.common.enums.YesNo;
import com.shop.modules.shop.domain.Slide;
import com.shop.modules.shop.domain.enums.SlideType;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SlideRepository extends JpaRepository<Slide,Long> {

    @Query("select s from Slide s where s.title like CONCAT('%',:text,'%')")
    Page<Slide> findFullText(@Param("text") String text, Pageable pageable);

    List<Slide> findByTypeEqualsAndIsShowEquals(SlideType slideType, Boolean yesNo);

}