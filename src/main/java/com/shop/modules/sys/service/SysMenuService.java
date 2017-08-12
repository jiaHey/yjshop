package com.shop.modules.sys.service;

import com.shop.modules.sys.dao.SysMenuRepository;
import com.shop.modules.sys.domain.SysMenu;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class SysMenuService {
    @Autowired
    private SysMenuRepository sysMenuRepository;

    public List<SysMenu> getUserMenuList(Long userId) {
        return sysMenuRepository.findMenuByUserId(userId);
    }

    public List<SysMenu> findAll() {
        return sysMenuRepository.findAll();
    }

    public List<String> findPermsByUserId(Long userId) {
        return sysMenuRepository.findPermsByUserId(userId);
    }

    public List<String> findPermsAll() {
        return sysMenuRepository.findPermsAll();
    }

    public List<SysMenu> findNotButtonList() {
        return sysMenuRepository.findNotButtonList();
    }

    public SysMenu save(SysMenu menu) {
        if(menu.getParentId()!=null&&menu.getParentId()<1) menu.setParentId(null);
        return sysMenuRepository.save(menu);
    }

    public SysMenu findByParentIdEquals(long id) {
        return sysMenuRepository.findByParentIdEquals(id);
    }

    public void deleteBatch(Iterable<SysMenu> ids) {
        sysMenuRepository.deleteInBatch(ids);
    }

    public void delete(Long id) {
        sysMenuRepository.delete(id);
    }

    public SysMenu findByIdEquals(Long id) {
        return sysMenuRepository.findByIdEquals(id);
    }

    public List<SysMenu> findAll(Iterable<Long> iterable){
        return sysMenuRepository.findAll(iterable);
    }

}
