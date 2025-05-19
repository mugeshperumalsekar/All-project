package com.ponsun.aml.banktransaction.AuditLog.services;


import com.ponsun.aml.banktransaction.AuditLog.domain.AuditLog;
import com.ponsun.aml.banktransaction.AuditLog.domain.AuditLogRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuditLogReadPlatformServiceImpl implements AuditLogReadPlatformService {

    private final AuditLogRepository auditLogRepository;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<AuditLog> fetchAllAuditLog() {
        return this.auditLogRepository.findAll();
    }
    @Override
    public AuditLog fetchAuditLogById(Integer id) {
        return this.auditLogRepository.findById(id).get();
    }
}










