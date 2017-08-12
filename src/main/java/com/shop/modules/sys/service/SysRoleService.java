package com.shop.modules.sys.service;

import com.shop.modules.sys.dao.SysRoleRepository;
import com.shop.modules.sys.domain.SysRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;

@Service
public class SysRoleService {

    @Autowired
    private SysRoleRepository sysRoleRepository;

    public Page<SysRole> findPageByName(String name, Pageable pageable) {
        return sysRoleRepository.findByNameContains(name, pageable);
    }

    public List<SysRole> findAll() {
        return sysRoleRepository.findAll();
    }

    public SysRole findOne(Long id) {
        return sysRoleRepository.findOne(id);
    }

    public SysRole save(SysRole role) {
        return sysRoleRepository.save(role);
    }

    public List<SysRole> findAll(Iterable<Long> iterable) {
        return sysRoleRepository.findAll(iterable);
    }

    public void deleteBatch(Long[] roleIds) {
        HashSet<SysRole> sysRoles = new HashSet<SysRole>();
        SysRole sysRole;
        for (Long id : roleIds) {
            sysRole=new SysRole();
            sysRole.setId(id);
            sysRoles.add(sysRole);
        }
        sysRoleRepository.deleteInBatch(sysRoles);
    }
}
