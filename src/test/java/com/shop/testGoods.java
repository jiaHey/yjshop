package com.shop;

import com.shop.modules.shop.dao.GoodsRepository;
import com.shop.modules.shop.domain.Goods;
import com.shop.modules.shop.domain.GoodsGallery;
import com.shop.modules.shop.service.GoodsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@SpringBootTest(classes = Application.class)
public class testGoods {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsRepository goodsRepository;

    @Test
    public void testSave() {
    }

    @Test
    public void testUpdate() {
        Goods goods =goodsService.findById(1L);
        goods.setTitle("asv");
        goods.setImgUrl("asd");
//        GoodsGallery goodsGallery = new GoodsGallery();
//        goodsGallery.setImgUrl("11");
//        goodsGallery.setId(1L);
//        Set<GoodsGallery> goodsGalleries = new HashSet<GoodsGallery>();
//        goodsGalleries.add(goodsGallery);
//        goods.setGallery(goodsGalleries);

        goodsService.saveGoods(goods);

    }

    @Test
    public void testDelete() {

        goodsService.deleteGoods(2L);

    }

    @Test
    public void testDetail() {
        Goods goods = goodsService.findDetailById(5L);
        System.out.println(goods.getGallery());
    }

    @Test
    public void testTags() {
        HashSet<Long> ids = new HashSet<Long>();
        ids.add(1L);
        ids.add(3L);
        ids.add(2L);
        goodsService.findByTags(ids);
    }

}
