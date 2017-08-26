package com.shop.modules.shop.service;

import com.shop.modules.shop.dao.GoodsTagsRepository;
import com.shop.modules.shop.domain.GoodsTags;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class GoodsTagsService {
    @Autowired
    private GoodsTagsRepository goodsTagsRepository;

    public Page<GoodsTags> findFullText(String keyword, PageRequest page) {
        return goodsTagsRepository.findFullText(keyword, page);
    }

    public GoodsTags findOne(Long id) {
        return goodsTagsRepository.findOne(id);
    }

    public GoodsTags save(GoodsTags goodsTags) {
        return  goodsTagsRepository.save(goodsTags);
    }

    public void delete(Long id) {
        goodsTagsRepository.delete(id);
    }

    public List<GoodsTags> findByIsShowEquals(Boolean isShow) {
       return goodsTagsRepository.findByIsShowEquals(isShow);
    }

    public List<GoodsTags> finAll(Iterable<Long> goodsTagsIdList) {
        return goodsTagsRepository.findAll(goodsTagsIdList);
    }
}
