package com.ponsun.aml.banktransaction.AuditLog.services;

import com.ponsun.aml.banktransaction.AuditLog.domain.AuditLog;

import java.util.List;

public interface AuditLogReadPlatformService {

    AuditLog fetchAuditLogById(Integer id);
    List<AuditLog> fetchAllAuditLog();
}
