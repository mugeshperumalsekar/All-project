package com.ponsun.aml.banktransaction.AuditLog.domain;


import com.ponsun.aml.banktransaction.AuditLog.request.AbstractAuditLogRequest;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuditLogRepositoryWrapper extends AbstractAuditLogRequest {
    private final AuditLogRepository AuditLogRepository;
    @Transactional
    public AuditLog findOneWithNotFoundDetection(final Integer id) {
        return this.AuditLogRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AuditLog Not found " + id));
    }
    @Override
    public String toString() {
        return super.toString();
    }
}