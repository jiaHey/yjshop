package com.shop.modules.sys.controller;

import com.shop.common.annotation.SysLog;
import com.shop.common.utils.PageUtil;
import com.shop.common.utils.R;
import com.shop.common.validator.Assert;
import com.shop.modules.sys.domain.SysRole;
import com.shop.modules.sys.domain.SysUser;
import com.shop.modules.sys.service.SysRoleService;
import com.shop.modules.sys.service.SysUserService;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.crypto.hash.Sha256Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/sys/user")
public class SysUserController extends AbstractController {
    @Autowired
    private SysUserService sysUserService;
    @Autowired
    private SysRoleService sysRoleService;
    @Autowired
    private HttpServletRequest request;

    /**
     * 所有用户列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:user:list")
    public R list() {
        //只有超级管理员，才能查看所有管理员列表
//        if(getUserId() != Constant.SUPER_ADMIN){
//        }
        String username = request.getParameter("username");
        if (username == null) {
            username = "";
        }
        Page<SysUser> sysUserPage = sysUserService.findPageByUsernameContains(username, PageUtil.page(request));
        return R.ok().put("page", sysUserPage);
    }

    /**
     * 获取登录的用户信息
     */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id) {
        SysUser user = sysUserService.findOne(id);
        //角色ids
        HashSet<Long> roleIdList = new HashSet<Long>();
        Iterator<SysRole> iterator = user.getSysRoles().iterator();
        while (iterator.hasNext()) {
            roleIdList.add(iterator.next().getId());
        }
        return R.ok().put("user", user).put("roleIdList", roleIdList);
    }

    /**
     * 保存用户
     */
    @SysLog("保存管理员")
    @RequestMapping("/save")
    @RequiresPermissions("sys:user:save")
    public R save(SysUser user) {
        user.setUserId(getUserId());

        //更新角色
        String[] roleIdList = request.getParameterValues("roleIdList[]");
        HashSet<Long> roleIds = new HashSet<Long>();
        for (String roleId : roleIdList) {
            roleIds.add(Long.parseLong(roleId));
        }
        List<SysRole> roles = sysRoleService.findAll(roleIds);
        user.setSysRoles(new HashSet<SysRole>(roles));
        sysUserService.save(user);

        return R.ok();
    }

    /**
     * 修改登录用户密码
     */
    @SysLog("修改密码")
    @RequestMapping("/password")
    public R password(String password, String newPassword) {
        Assert.isBlank(newPassword, "新密码不为能空");

        //sha256加密
        password = new Sha256Hash(password, "").toHex();
        //sha256加密
        newPassword = new Sha256Hash(newPassword, "").toHex();

        //更新密码
//        int count = sysUserService.updatePassword(getUserId(), password, newPassword);
//        if(count == 0){
//            return R.error("原密码不正确");
//        }

        return R.ok();
    }

    @SysLog("删除管理员")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:user:delete")
    public R delete(@RequestBody Long[] userIds) {
        if (ArrayUtils.contains(userIds, 1L)) {
            return R.error("系统管理员不能删除");
        }
        if (ArrayUtils.contains(userIds, getUserId())) {
            return R.error("当前用户不能删除");
        }
        sysUserService.deleteBatch(userIds);
        return R.ok();
    }
}
