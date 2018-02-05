package com.shop.modules.sys.service;

import com.shop.modules.sys.dao.SysUserRepository;
import com.shop.modules.sys.domain.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysUserService {
    @Autowired
    private SysUserRepository sysUserRepository;

    public Page<SysUser> findPageByUsernameContains(String userName, Pageable pageable) {
        return sysUserRepository.findByUsernameContains(userName, pageable);
    }

    public Integer countByName(String name) {
        return sysUserRepository.countByUsernameContains(name);
    }

    public SysUser findOne(Long id) {
        return sysUserRepository.findOne(id);
    }

    public void deleteBatch(Long[] userIds) {
        ArrayList<SysUser> sysUsers = new ArrayList<SysUser>();
        for (Long uid : userIds) {
            SysUser user = new SysUser();
            user.setId(uid);
            sysUsers.add(user);
        }
        sysUserRepository.deleteInBatch(sysUsers);
    }

    @Transactional
    public SysUser save(SysUser user) {
        return sysUserRepository.save(user);
    }

    public SysUser findByUsernameEquals(String username) {
        return sysUserRepository.findByUsernameEquals(username);
    }
}
