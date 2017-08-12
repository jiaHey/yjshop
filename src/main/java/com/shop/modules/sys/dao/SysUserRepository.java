package com.shop.modules.sys.dao;

import com.shop.modules.sys.domain.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysUserRepository extends JpaRepository<SysUser, Long> {

    Page<SysUser> findByUsernameContains(String name, Pageable pageable);

    Integer countByUsernameContains(String string);
}