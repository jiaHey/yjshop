package com.shop.modules.sys.controller;

import com.shop.common.annotation.SysLog;
import com.shop.common.utils.Constant;
import com.shop.common.utils.R;
import com.shop.modules.sys.domain.SysMenu;
import com.shop.modules.sys.service.ShiroService;
import com.shop.modules.sys.service.SysMenuService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/sys/menu")
public class SysMenuController extends AbstractController {
    @Autowired
    private SysMenuService sysMenuService;
    @Autowired
    private ShiroService shiroService;

    /**
     * 导航菜单
     */
    @RequestMapping("/nav")
    public R nav() {
        Long userId = getUserId();
        List<SysMenu> menuList;
        if (userId == Constant.SUPER_ADMIN) {
            menuList = sysMenuService.findMenuList();
        } else {
            menuList = sysMenuService.findUserMenuList(getUserId());
        }
        Set<String> permissions = shiroService.getUserPermissions(getUserId());
        return R.ok().put("menuList", menuList).put("permissions", permissions);
    }

    /**
     * 所有菜单列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:menu:list")
    public List<SysMenu> list() {
        List<SysMenu> menuList = sysMenuService.findAll();
        return menuList;
    }

    /**
     * 选择菜单(添加、修改菜单)
     */
    @RequestMapping("/select")
    @RequiresPermissions("sys:menu:select")
    public R select() {
        //查询列表数据
        List<SysMenu> menuList = sysMenuService.findMenuList();

        //添加顶级菜单
        SysMenu root = new SysMenu();
        root.setId(null);
        root.setName("一级菜单");
        root.setParentId(-1L);
        menuList.add(root);
        return R.ok().put("menuList", menuList);
    }

    /**
     * 菜单信息
     */
    @RequestMapping("/info/{menuId}")
    @RequiresPermissions("sys:menu:info")
    public R info(@PathVariable("menuId") Long menuId) {
        SysMenu menu = sysMenuService.findByIdEquals(menuId);
        SysMenu parent = sysMenuService.findByIdEquals(menu.getParentId());
        return R.ok().put("menu", menu).put("parent", parent);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @SysLog("保存菜单")
    @RequiresPermissions("sys:menu:save")
    public R save(@Valid SysMenu menu) {
        //数据校验

        sysMenuService.save(menu);

        return R.ok();
    }

    /**
     * 删除
     */
    @SysLog("删除菜单")
    @RequestMapping("/delete")
    @RequiresPermissions("sys:menu:delete")
    public R delete(long menuId) {
        if (menuId <= 30) {
            return R.error("系统菜单，不能删除");
        }
        //判断是否有子菜单或按钮
        SysMenu byParentId = sysMenuService.findByParentIdEquals(menuId);
        if (byParentId != null) {
            return R.error("请先删除子菜单或按钮");
        }
        sysMenuService.delete(menuId);
        return R.ok();
    }
}
