package com.shop.modules.shop.controller.admin;

import com.shop.common.annotation.SysLog;
import com.shop.common.utils.PageUtil;
import com.shop.common.utils.R;
import com.shop.modules.shop.domain.Coupon;
import com.shop.modules.shop.service.CouponService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by heyujia on 2017/12/13.
 */
@RestController
@RequestMapping("/admin/coupon")
public class CouponAdminController {
    @Autowired
    private HttpServletRequest request;
    @Autowired
    private CouponService couponService;

    @RequestMapping("/list")
    public R index() {
        String keyword = request.getParameter("keyword");
        if (keyword == null) {
            keyword = "";
        }
        Page<Coupon> coupon = couponService.findFullText(keyword, PageUtil.page(request));
        return R.ok().put("page", coupon);
    }

    @RequestMapping(value = "/info/{id}")
    public R info(@PathVariable Long id) {
        Coupon coupon = couponService.findOne(id);
        return R.ok().put("coupon", coupon);
    }

    @SysLog("保存优惠券")
    @RequestMapping(value = "/save")
    public R save(@RequestBody Coupon coupon) {
        couponService.save(coupon);
        return R.ok();
    }

    @SysLog("删除优惠券")
    @RequestMapping(value = "/delete")
    public R delete(@RequestBody Long[] couponIds) {
        couponService.deleteBatch(couponIds);
        return R.ok();
    }

}
