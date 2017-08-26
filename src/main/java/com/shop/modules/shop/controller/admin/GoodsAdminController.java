package com.shop.modules.shop.controller.admin;

import com.shop.common.annotation.SysLog;
import com.shop.common.utils.PageUtil;
import com.shop.common.utils.R;
import com.shop.modules.shop.domain.Goods;
import com.shop.modules.shop.domain.GoodsGallery;
import com.shop.modules.shop.domain.GoodsTags;
import com.shop.modules.shop.domain.vo.GoodsVo;
import com.shop.modules.shop.service.GoodsService;
import com.shop.modules.shop.service.GoodsTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/admin/goods")
public class GoodsAdminController {
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private GoodsTagsService goodsTagsService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/list")
    public R index() {
        String keyword = request.getParameter("keyword");
        if (keyword == null) {
            keyword = "";
        }
        Page<Goods> goods = goodsService.findFullText(keyword, PageUtil.page(request));
        return R.ok().put("page", goods);
    }

    @RequestMapping(value = "/info/{id}")
    public R info(@PathVariable Long id) {
        Goods goods = goodsService.findDetailById(id);
        Set<GoodsGallery> gallery = goods.getGallery();
        List<GoodsTags> goodsTags = goodsTagsService.findByIsShowEquals(true);
        HashSet<Long> goodsTagsIdList = new HashSet<Long>();
        Iterator<GoodsTags> iterator = goods.getTags().iterator();
        while (iterator.hasNext()) {
            goodsTagsIdList.add(iterator.next().getId());
        }

        return R.ok().put("goods", goods)
                .put("goodsTags", goodsTags)
                .put("goodsTagsIdList", goodsTagsIdList)
                .put("gallery", gallery);
    }

    @SysLog("保存商品")
    @RequestMapping(value = "/save")
    public R save(@RequestBody GoodsVo goodsVo) {
        Goods orgGoods = goodsVo.getGoods();
        Goods goods = goodsService.findDetailById(orgGoods.getId());
        if(goods==null){
            goods=new Goods();
        }
        goods.setTitle(orgGoods.getTitle());
        goods.setImgUrl(orgGoods.getImgUrl());
        goods.setPrice(orgGoods.getPrice());
        goods.setContent(orgGoods.getContent());
        //相册
        goods.setGallery(new HashSet<GoodsGallery>(goodsVo.getGallery()));
        //标签
        List<GoodsTags> goodsTags = goodsTagsService.finAll(goodsVo.getGoodsTagsIdList());
        goods.setTags(new HashSet<GoodsTags>(goodsTags));
        goodsService.save(goods);
        return R.ok();
    }

    @SysLog("删除商品")
    @RequestMapping(value = "/delete")
//    @RequiresPermissions("sys:user:delete")
    public R delete(@RequestBody Long[] userIds) {
        goodsService.deleteBatch(userIds);
        return R.ok();

    }
}
