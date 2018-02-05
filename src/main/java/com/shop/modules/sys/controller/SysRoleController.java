package com.shop.modules.sys.controller;

import com.shop.common.annotation.SysLog;
import com.shop.common.utils.Constant;
import com.shop.common.utils.PageUtil;
import com.shop.common.utils.R;
import com.shop.modules.sys.domain.SysMenu;
import com.shop.modules.sys.domain.SysRole;
import com.shop.modules.sys.service.SysMenuService;
import com.shop.modules.sys.service.SysRoleService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@RestController
@RequestMapping("/sys/role")
public class SysRoleController extends AbstractController {

    @Autowired
    private SysRoleService sysRoleService;

    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private HttpServletRequest request;

    /**
     * 角色列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:role:list")
    public R list() {
        //如果不是超级管理员，则只查询自己创建的角色列表
//        if(getUserId() != Constant.SUPER_ADMIN){
//            params.put("createUserId", getUserId());
//        }
        String name = request.getParameter("username");
        if (name == null) {
            name = "";
        }
        Page<SysRole> page = sysRoleService.findPageByName(name, PageUtil.page(request));
        return R.ok().put("page", page);
    }

    /**
     * 角色列表
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:role:select")
    public R select() {
        List<SysRole> list = sysRoleService.findAll();
        return R.ok().put("list", list);
    }

    /**
     * 角色信息
     */
    @RequestMapping("/info/{roleId}")
    @RequiresPermissions("sys:role:info")
    public R info(@PathVariable("roleId") Long roleId) {
        SysRole role = sysRoleService.findOne(roleId);
        //查询角色对应的菜单
        HashSet<Long> menuIdList = new HashSet<Long>();
        Iterator<SysMenu> iterator = role.getSysMenus().iterator();
        while (iterator.hasNext()) {
            SysMenu menu = iterator.next();
            menuIdList.add(menu.getId());
        }

        return R.ok().put("role", role).put("menuIdList", menuIdList);
    }

    /**
     * 保存角色
     */
    @SysLog("保存角色")
    @RequestMapping("/save")
    @RequiresPermissions("sys:role:save")
    public R save(SysRole role) {
        SysRole sysRole;
        if (role.getId() == null) {
            sysRole = new SysRole();
            sysRole.setUserId(getUserId());
        } else {
            sysRole=sysRoleService.findOne(role.getId());
        }
        //更新角色
        sysRole.setName(role.getName());
        sysRole.setRemark(role.getRemark());
        //更新菜单
        String[] menuIdLists = request.getParameterValues("menuIdList[]");
        if (menuIdLists != null) {
            HashSet<Long> menuIds = new HashSet<Long>();
            for (String menuId : menuIdLists) {
                menuIds.add(Long.parseLong(menuId));
            }
            List<SysMenu> menuList = sysMenuService.findAll(menuIds);
            sysRole.setSysMenus(new HashSet<SysMenu>(menuList));
        } else {
            sysRole.setSysMenus(null);
        }
        sysRoleService.save(sysRole);
        return R.ok();
    }

    /**
     * 删除角色
     */
    @SysLog("删除角色")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:role:delete")
    public R delete(@RequestBody Long[] roleIds) {
        sysRoleService.deleteBatch(roleIds);

        return R.ok();
    }

}
