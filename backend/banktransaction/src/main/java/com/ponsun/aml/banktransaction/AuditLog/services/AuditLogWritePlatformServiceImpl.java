package com.ponsun.aml.banktransaction.AuditLog.services;

import com.ponsun.aml.banktransaction.AuditLog.data.AuditLogDataValidator;
import com.ponsun.aml.banktransaction.AuditLog.domain.AuditLog;
import com.ponsun.aml.banktransaction.AuditLog.domain.AuditLogRepository;
import com.ponsun.aml.banktransaction.AuditLog.domain.AuditLogRepositoryWrapper;
import com.ponsun.aml.banktransaction.AuditLog.request.CreateAuditLogRequest;
import com.ponsun.aml.banktransaction.AuditLog.request.UpdateAuditLogRequest;
import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuditLogWritePlatformServiceImpl implements AuditLogWritePlatformService {

    private final AuditLogRepository auditLogRepository;
    private final AuditLogRepositoryWrapper auditLogRepositoryWrapper;
    private final AuditLogDataValidator auditLogDataValidator;
    @Override
    @Transactional
    public Response createAuditLog(CreateAuditLogRequest createAuditLogRequest) {
        try{
            this.auditLogDataValidator.validateSaveAuditLog(createAuditLogRequest);
            final AuditLog auditLog = AuditLog.create(createAuditLogRequest);
            this.auditLogRepository.saveAndFlush(auditLog);
            return Response.of(auditLog.getId());
        } catch (AppicationException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    @Transactional
    public Response updateAuditLogById(Integer id, UpdateAuditLogRequest updateAuditLogRequest) {
        try {
            this.auditLogDataValidator.validateUpdateAuditLog(updateAuditLogRequest);
            final AuditLog auditLog = this.auditLogRepositoryWrapper.findOneWithNotFoundDetection(id);
            auditLog.update(updateAuditLogRequest);
            this.auditLogRepository.saveAndFlush(auditLog);
            return Response.of(auditLog.getId());
        } catch (AppicationException e) {
            throw new RuntimeException(e);
        }
    }
}
