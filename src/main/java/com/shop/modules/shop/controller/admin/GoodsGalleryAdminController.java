package com.shop.modules.shop.controller.admin;


import com.shop.common.annotation.SysLog;
import com.shop.common.utils.R;
import com.shop.modules.shop.dao.GoodsGalleryRepository;
import com.shop.modules.shop.domain.Goods;
import com.shop.modules.shop.domain.GoodsGallery;
import com.shop.modules.shop.service.GoodsGalleryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin/goodsGallery")
public class GoodsGalleryAdminController {
    @Autowired
    private GoodsGalleryService goodsGalleryService;
    @RequestMapping(value = "/save")
    public R save(GoodsGallery goodsGallery) {
        goodsGalleryService.save(goodsGallery);
        return R.ok();
    }

    @RequestMapping(value = "/delete")
    public R delete( Long id) {
        goodsGalleryService.delete(id);
        return R.ok();
    }
}
