package com.shop.modules.shop.controller.admin;

import com.shop.common.annotation.SysLog;
import com.shop.common.utils.PageUtil;
import com.shop.common.utils.R;
import com.shop.modules.shop.domain.*;
import com.shop.modules.shop.service.AddressService;
import com.shop.modules.shop.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.Set;

@Controller
@RequestMapping("/admin/order")
public class OrderAdminController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/list")
    public R index() {
        String keyword = request.getParameter("keyword");
        if (keyword == null) {
            keyword = "";
        }
        Page<Order> orders = orderService.findFullText(keyword, PageUtil.page(request));
        return R.ok().put("page", orders);
    }

    @RequestMapping(value = "/info/{id}")
    public R info(@PathVariable Long id) {
        Order order = orderService.findDetailById(id);
        String addressStr = order.getAddressStr();
        Set<OrderGoods> orderGoods = order.getOrderGoods();
        return R.ok().put("order", order);
    }

    @SysLog("保存订单")
    @RequestMapping(value = "/save")
    public R save(Order order) {
        orderService.save(order);
        return R.ok();
    }

    @SysLog("删除商品")
    @RequestMapping(value = "/delete")
    public R delete(@RequestBody Long id) {
        orderService.delete(id);
        return R.ok();

    }
}
