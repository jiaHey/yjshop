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

    @Query("select m.perms from SysMenu m where 1L=:uid")
    List<String> findPermsByUserId(@Param("uid") Long uid);

    @Query("select m.perms from SysMenu m")
    List<String> findPermsAll();

    @Query("select m from SysMenu m where m.type <> 2")
    List<SysMenu> findNotButtonList();

    SysMenu findByParentIdEquals(Long pid);

    SysMenu findByIdEquals(Long id);
}