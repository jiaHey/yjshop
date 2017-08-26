package com.shop.modules.shop.controller.home;

import com.shop.common.utils.PageUtil;
import com.shop.common.utils.R;
import com.shop.modules.shop.domain.Goods;
import com.shop.modules.shop.domain.GoodsGallery;
import com.shop.modules.shop.service.GoodsService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/home/goods")
public class GoodsHomeController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/newsGoods")
    public R newsGoods() {
        Page<Goods> pageGoods = goodsService.findAll(PageUtil.page(request));
        return R.ok().put("page", pageGoods);
    }

    @RequestMapping("/searchGoods")
    public R searchGoods() {
        String search = request.getParameter("search");
        if (search == null) {
            search = "";
        }
        Page<Goods> pageGoods = goodsService.findFullText(search, PageUtil.page(request));
        return R.ok().put("page", pageGoods);
    }

    @RequestMapping("/goodsDetail")
    public R goodsDetail() {
        String id = request.getParameter("id");
        Goods goods = goodsService.findDetailById(Long.parseLong(id));
        Set<GoodsGallery> gallery = goods.getGallery();
        return R.ok().put("goods", goods).put("gallery",gallery);
    }

    @RequestMapping("/goodsTags")
    public R goodsTags() {
        String id = request.getParameter("id");
        Page<Goods> goodsList = goodsService.findByTags(Long.parseLong(id), PageUtil.page(request));
        return R.ok().put("goodsList", goodsList);
    }
}

