package com.shop.modules.sys.dao;

import com.shop.modules.sys.domain.SysRole;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SysRoleRepository extends JpaRepository<SysRole, Long> {

    public Page<SysRole> findByNameContains(String name, Pageable pageable);
}