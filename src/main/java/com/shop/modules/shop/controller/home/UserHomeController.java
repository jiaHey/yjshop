package com.shop.modules.shop.controller.home;

import com.shop.common.utils.R;
import com.shop.modules.shop.domain.User;
import com.shop.modules.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home/user")
public class UserHomeController {
    @Autowired
    private UserService userService;

    @RequestMapping("userInfo")
    public R userInfo() {
        User user = userService.loginWx();
        return R.ok().put("user", user);
    }
}
