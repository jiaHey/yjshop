package com.shop.modules.shop.service;

import com.shop.modules.shop.dao.GoodsGalleryRepository;
import com.shop.modules.shop.domain.Goods;
import com.shop.modules.shop.domain.GoodsGallery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GoodsGalleryService {
    @Autowired
    private GoodsGalleryRepository goodsGalleryRepository;

    public GoodsGallery save(GoodsGallery goodsGallery) {
        return goodsGalleryRepository.save(goodsGallery);
    }


    public void delete(Long id) {
        goodsGalleryRepository.delete(id);
    }
}
