package com.shop.modules.shop.controller.home;

import com.shop.common.utils.R;
import com.shop.modules.shop.domain.GoodsTags;
import com.shop.modules.shop.service.GoodsTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/home/goodsTags")
public class GoodsTagsHomeController {

    @Autowired
    private GoodsTagsService goodsTagsService;

    @RequestMapping("/goodsTagsList")
    public R goodsTagsList() {
        List<GoodsTags> goodsTagsList = goodsTagsService.findByIsShowEquals(true);
        return R.ok().put("goodsTagsList", goodsTagsList);
    }
}
