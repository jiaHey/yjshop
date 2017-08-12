package com.shop.modules.shop.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/api/user")
public class UserController {
    private Map<String,Object> map=new HashMap<String, Object>();
    @ResponseBody
    @RequestMapping("/userInfo")
    public Object userInfo(){
        return map;
    }
}
