package com.shop.modules.shop.controller.home;

import com.shop.common.utils.PageUtil;
import com.shop.common.utils.R;
import com.shop.modules.shop.domain.Address;
import com.shop.modules.shop.domain.Order;
import com.shop.modules.shop.domain.User;
import com.shop.modules.shop.domain.enums.OrderStatus;
import com.shop.modules.shop.service.AddressService;
import com.shop.modules.shop.service.OrderService;
import com.shop.modules.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/home/order")
public class OrderHomeController {
    @Autowired
    private OrderService orderService;
    @Autowired
    private UserService userService;
    @Autowired
    private AddressService addressService;
    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/orderList")
    public R orderList() {
        User user = userService.loginWx();
        Page<Order> page = orderService.findDetailByUserEquals(user, PageUtil.page(request));
        return R.ok().put("page", page);
    }

    @RequestMapping("/orderDetail")
    public R orderDetail(Long id) {
        Order order = orderService.findDetailById(id);
        return R.ok().put("order", order);
    }

    @RequestMapping("/orderCancel")
    public R orderCancel(Long id) {
        Order order = orderService.findOne(id);
        if (OrderStatus.UNPAID == order.getStatus()) {
            order.setStatus(OrderStatus.CANCELED);
        } else if (OrderStatus.PAID == order.getStatus()) {
            order.setStatus(OrderStatus.CANCELING);
        } else {
            return R.error();
        }
        orderService.save(order);
        return R.ok();
    }

    @RequestMapping("/createOrder")
    public R createOrder() {
        User user = userService.loginWx();
        Address address = addressService.findDefaultAddress(user.getId());
        if (address == null) {
            return R.error("没有默认地址").put("code",302);
        }
        orderService.createOrder(user, address);
        return R.ok();
    }
}
