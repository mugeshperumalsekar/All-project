package com.ponsun.aml.banktransaction.AuditLog.data;

import lombok.Data;

@Data
public class AuditLogData {
    private Integer id;
    private Integer levelId;
    private String customerId;
    private Integer alertId;
    private String name;

    public  AuditLogData (final Integer id ,final Integer levelId, final String customerId ,final Integer alertId, final  String name) {
        this.id = id;
        this.levelId = levelId;
        this.customerId = customerId;
        this.alertId = alertId;
        this.name = name;
    }

    public static AuditLogData newInstance (final Integer id ,final Integer levelId, final String customerId , final Integer alertId , final  String name) {
        return new AuditLogData(id, levelId, customerId, alertId , name);
    }
}
