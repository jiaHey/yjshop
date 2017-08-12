package com.shop.modules.shop.controller;

import com.shop.common.annotation.SysLog;
import com.shop.common.utils.PageUtil;
import com.shop.common.utils.R;
import com.shop.modules.shop.domain.GoodsTags;
import com.shop.modules.shop.service.GoodsTagsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin/goodsTags")
public class GoodsTagsAdminController {
    @Autowired
    private GoodsTagsService goodsTagsService;
    @Autowired
    private HttpServletRequest request;
    @RequestMapping("/list")
    public R lists() {
        String keyword = request.getParameter("keyword");
        if (keyword == null) {
            keyword = "";
        }
        Page<GoodsTags> page = goodsTagsService.findFullText(keyword, PageUtil.page(request));
        return R.ok().put("page",page);
    }

    @RequestMapping(value = "/info/{id}")
    public R info(@PathVariable Long id) {
        GoodsTags one = goodsTagsService.findOne(id);
        return R.ok().put("goodsTags", one);
    }

    @RequestMapping(value = "/save")
    public R save(@RequestBody GoodsTags goodsTags) {
        goodsTagsService.save(goodsTags);
        return R.ok();
    }

    @RequestMapping(value = "/delete")
    public R delete(Long id){
        goodsTagsService.delete(id);
        return R.ok();
    }
}
