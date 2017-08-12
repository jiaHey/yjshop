package com.shop.modules.sys.dao;

import com.shop.modules.sys.domain.SysLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SysLogRepository extends JpaRepository<SysLog, Long> {
}