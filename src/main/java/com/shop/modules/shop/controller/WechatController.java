package com.shop.modules.shop.controller;

import com.shop.modules.shop.domain.User;
import com.shop.modules.shop.service.UserService;
import me.chanjar.weixin.common.exception.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.result.WxMpOAuth2AccessToken;
import me.chanjar.weixin.mp.bean.result.WxMpUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/wechat")
public class WechatController {

    @Autowired
    private HttpServletRequest request;
    @Autowired
    private UserService userService;
    @ResponseBody
    @RequestMapping("/")
    public Object index() {
        User user = userService.loginWx();
        return user;
    }
}
