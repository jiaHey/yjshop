package com.shop.modules.shop.dao;

import com.shop.modules.shop.domain.GoodsGallery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface GoodsGalleryRepository extends JpaRepository<GoodsGallery, Long>, JpaSpecificationExecutor
{

}
