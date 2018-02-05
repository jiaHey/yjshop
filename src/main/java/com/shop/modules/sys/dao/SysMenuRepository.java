package com.shop.modules.sys.dao;

import com.shop.modules.sys.domain.SysMenu;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SysMenuRepository extends JpaRepository<SysMenu, Long> {
    @Query("select m from SysMenu m where 1L=:uid")
    List<SysMenu> findMenuByUserId(@Param("uid") Long uid);

    @Query("select m.perms from SysMenu m join m.sysRoles r join r.sysUsers u where u.id=:uid")
    List<String> findPermsByUserId(@Param("uid") Long uid);

    @Query("select m.perms from SysMenu m")
    List<String> findPermsAll();

    @Query("select m from SysMenu m where m.type <> 2")
    List<SysMenu> findMenuList();

    @Query("select m from SysMenu m join m.sysRoles r join r.sysUsers u where u.id=:uid and  m.type <> 2")
    List<SysMenu> findUserMenuList(@Param("uid") Long uid);

    SysMenu findByParentIdEquals(Long pid);

    SysMenu findByIdEquals(Long id);
}