package com.shop.modules.shop.controller.admin;

import com.shop.common.utils.PageUtil;
import com.shop.common.utils.R;
import com.shop.modules.shop.domain.Slide;
import com.shop.modules.shop.service.SlideService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/admin/slide")
public class SlideAdminController {
    @Autowired
    private SlideService slideService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/list")
    public R index() {
        String text = request.getParameter("keyword");
        if (text == null) {
            text = "";
        }
        Page<Slide> page = slideService.findFullText(text, PageUtil.page(request));
        return R.ok().put("page", page);
    }

    @RequestMapping(value = "/info/{id}")
    public R info(@PathVariable Long id) {
        Slide slide = slideService.findById(id);
        return R.ok().put("slide", slide);
    }

    @RequestMapping(value = "/save")
    public R save(@RequestBody Slide slide) {
        slideService.save(slide);
        return R.ok();
    }

    @RequestMapping(value = "/delete")
    public R delete(Long id) {
        slideService.delete(id);
        return R.ok();
    }
}
