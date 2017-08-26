package com.shop.modules.shop.controller.home;

import com.shop.common.utils.PageUtil;
import com.shop.common.utils.R;
import com.shop.modules.shop.domain.Goods;
import com.shop.modules.shop.domain.Slide;
import com.shop.modules.shop.service.GoodsService;
import com.shop.modules.shop.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/home/index")
public class IndexHomeController {

    @Autowired
    private SlideService slideService;
    @Autowired
    private GoodsService goodsService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/")
    public R index() {
        List<Slide> slide = slideService.homeSlide();
        Page<Goods> page = goodsService.findAll(PageUtil.page(request));
        return R.ok().put("slide", slide).put("page", page);
    }
}
