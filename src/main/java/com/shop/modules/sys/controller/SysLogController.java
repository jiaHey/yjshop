package com.shop.modules.sys.controller;

import com.shop.common.utils.PageUtil;
import com.shop.common.utils.R;
import com.shop.modules.sys.domain.SysLog;
import com.shop.modules.sys.service.SysLogService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/sys/log")
public class SysLogController {
    @Autowired
    private SysLogService sysLogService;

    @Autowired
    private HttpServletRequest request;
    /**
     * 列表
     */
    @ResponseBody
    @RequestMapping("/list")
    @RequiresPermissions("sys:log:list")
    public R list(){
        //查询列表数据
        Page<SysLog> page = sysLogService.findAll(PageUtil.page(request));
        return R.ok().put("page", page);
    }
}
