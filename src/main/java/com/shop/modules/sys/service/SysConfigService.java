package com.shop.modules.sys.service;

import com.shop.modules.sys.dao.SysConfigRepository;
import com.shop.modules.sys.domain.SysConfig;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

@Service
public class SysConfigService {
    @Autowired
    private SysConfigRepository sysConfigRepository;

    public SysConfig save(SysConfig sysConfig) {
        return sysConfigRepository.save(sysConfig);
    }


    public Page<SysConfig> findFullText(String text, PageRequest page) {
        return sysConfigRepository.findFullText(text, page);
    }

    public SysConfig findByNameEquals(String name) {
        return sysConfigRepository.findByNameEquals(name);
    }

    public void delete(SysConfig sysConfig) {
        sysConfigRepository.delete(sysConfig);
    }

    public void delete(String[] names) {
        HashSet<SysConfig> sysConfigs = new HashSet<SysConfig>();
        SysConfig sysConfig;
        for (String name : names) {
            sysConfig = new SysConfig();
            sysConfig.setName(name);
            sysConfigs.add(sysConfig);
        }
        sysConfigRepository.delete(sysConfigs);
    }
}
