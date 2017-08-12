package com.shop.modules.shop.controller;

import com.shop.common.utils.PageUtil;
import com.shop.common.utils.R;
import com.shop.modules.shop.domain.User;
import com.shop.modules.shop.service.OrderService;
import com.shop.modules.shop.service.UserService;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin/user")
public class UserAdminController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserService userService;

    @RequestMapping("/list")
    public R lists() {
        String keyword = request.getParameter("keyword");
        if (keyword == null) {
            keyword = "";
        }
        Page<User> page = userService.findFullText(keyword, PageUtil.page(request));
        return R.ok().put("page", page);
    }
}
