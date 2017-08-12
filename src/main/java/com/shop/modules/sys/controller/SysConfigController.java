package com.shop.modules.sys.controller;

import com.shop.common.annotation.SysLog;
import com.shop.common.utils.PageUtil;
import com.shop.common.utils.R;
import com.shop.modules.sys.domain.SysConfig;
import com.shop.modules.sys.service.SysConfigService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/sys/config")
public class SysConfigController extends AbstractController {
    @Autowired
    private SysConfigService sysConfigService;

    @Autowired
    private HttpServletRequest request;

    @RequestMapping("/list")
    @RequiresPermissions("sys:config:list")
    public R list() {
        String text = request.getParameter("key");
        if (text == null) {
            text = "";
        }
        Page<SysConfig> page = sysConfigService.findFullText(text, PageUtil.page(request));
        return R.ok().put("page", page);
    }

    @RequestMapping("/save")
    @SysLog("保存配置")
    @RequiresPermissions("sys:config:save")
    public R save(SysConfig sysConfig) {
        sysConfigService.save(sysConfig);
        return R.ok();
    }

    /**
     * 配置信息
     */
    @RequestMapping("/info/{name}")
    @RequiresPermissions("sys:config:info")
    public R info(@PathVariable("name") String name) {
        SysConfig config = sysConfigService.findByNameEquals(name);
        return R.ok().put("config", config);
    }

    /**
     * 删除配置
     */
    @SysLog("删除配置")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:config:delete")
    public R delete() {
        String[] names = request.getParameterValues("name[]");
        sysConfigService.delete(names);
        return R.ok();
    }
}
