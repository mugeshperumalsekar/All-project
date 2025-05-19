package com.ponsun.aml.banktransaction.AuditLog.services;

import com.ponsun.aml.banktransaction.AuditLog.request.CreateAuditLogRequest;
import com.ponsun.aml.banktransaction.AuditLog.request.UpdateAuditLogRequest;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;

public interface AuditLogWritePlatformService {
    Response createAuditLog(CreateAuditLogRequest createAuditLogRequest);

    Response updateAuditLogById(Integer id, UpdateAuditLogRequest updateAuditLogRequest);
}
