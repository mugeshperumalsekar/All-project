package com.ponsun.aml.banktransaction.AuditLog.request;

import lombok.Data;

@Data
public class AbstractAuditLogRequest {

    private Integer id;
    private Integer levelId;
    private String customerId;
    private Integer alertId;
    private String name;
}
