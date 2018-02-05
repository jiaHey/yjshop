package com.shop.modules.sys.controller;

import com.shop.modules.sys.domain.SysUser;
import org.apache.shiro.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Controller公共组件
 */
public abstract class AbstractController {
    protected Logger logger = LoggerFactory.getLogger(getClass());

    public SysUser getSysUser() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }


    protected Long getUserId() {
        return getSysUser().getId();
    }
}
