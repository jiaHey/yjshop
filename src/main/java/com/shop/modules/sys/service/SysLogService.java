package com.shop.modules.sys.service;

import com.shop.modules.sys.dao.SysLogRepository;
import com.shop.modules.sys.domain.SysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class SysLogService {
    @Autowired
    private SysLogRepository sysLogRepository;
    public SysLog save(SysLog sysLog) {
        return sysLogRepository.save(sysLog);
    }

    public Page<SysLog> findAll(Pageable pageable) {
        return sysLogRepository.findAll(pageable);
    }
}
