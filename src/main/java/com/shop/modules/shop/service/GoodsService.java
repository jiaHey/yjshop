package com.shop.modules.shop.service;

import com.shop.modules.shop.dao.GoodsRepository;
import com.shop.modules.shop.domain.Goods;
import com.shop.modules.sys.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GoodsService {

    @Autowired
    private GoodsRepository goodsRepository;

    public Page<Goods> findFullText(String text, Pageable pageable) {
        return goodsRepository.findFullText(text, pageable);
    }

    public Goods save(Goods goods) {
        goods.setUpdated(new Date());
        if (goods.getId() == null) {
            goods.setSaleCount(0);
        }
        return goodsRepository.save(goods);
    }

    public void deleteGoods(Long id) {
        goodsRepository.delete(id);
    }

    public Goods findById(Long id) {
        return goodsRepository.findOne(id);
    }

    public Goods findDetailById(Long id) {
        return goodsRepository.findDetailById(id);
    }

    public Page<Goods> findByTagsIn(Set<Long> ids,Pageable pageable) {
        return goodsRepository.findByTagsIn(ids,pageable);
    }

    public Page<Goods> findByTags(Long id,Pageable pageable) {
        return goodsRepository.findByTags(id,pageable);
    }

    public void deleteBatch(Long[] userIds) {
        ArrayList<Goods> goodsArrayList = new ArrayList<Goods>();
        Goods goods;
        for (Long uid : userIds) {
            goods = new Goods();
            goods.setId(uid);
            goodsArrayList.add(goods);
        }
        goodsRepository.deleteInBatch(goodsArrayList);
    }

    public Goods findOne(Long id) {
        return goodsRepository.findOne(id);
    }

    public Page<Goods> findAll(Pageable pageable) {
        return goodsRepository.findAll(pageable);
    }
}
