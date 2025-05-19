package com.ponsun.aml.banktransaction.AuditLog.domain;


import com.ponsun.aml.banktransaction.AuditLog.request.CreateAuditLogRequest;
import com.ponsun.aml.banktransaction.AuditLog.request.UpdateAuditLogRequest;
import com.ponsun.aml.banktransaction.common.entity.Status;
import com.ponsun.aml.banktransaction.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "bank_audit_log")

public class AuditLog extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "alertId")
    private Integer alertId;

    @Column(name = "levelId")
    private Integer levelId;

    @Column(name = "customerId")
    private String customerId;

    @Column(name = "name")
    private String name;

    public static AuditLog create(final CreateAuditLogRequest createAuditLogRequest) {
        if (createAuditLogRequest == null) {
            throw new IllegalArgumentException("createAuditLogRequest cannot be null");
        }

        final AuditLog auditLog = new AuditLog();
        auditLog.setLevelId(createAuditLogRequest.getLevelId());
        auditLog.setCustomerId(createAuditLogRequest.getCustomerId());
        auditLog.setName(createAuditLogRequest.getName());
        auditLog.setAlertId(createAuditLogRequest.getAlertId());
        auditLog.onCreate();
        auditLog.setStatus(Status.ACTIVE);
        return auditLog;
    }


    public void update(UpdateAuditLogRequest updateAuditLogRequest) {
        this.setLevelId(updateAuditLogRequest.getLevelId());
        this.setCustomerId(updateAuditLogRequest.getCustomerId());
        this.setName(updateAuditLogRequest.getName());
        this.setAlertId(updateAuditLogRequest.getAlertId());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }

}