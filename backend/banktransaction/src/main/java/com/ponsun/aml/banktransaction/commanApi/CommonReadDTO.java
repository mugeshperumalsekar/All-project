package com.ponsun.aml.banktransaction.commanApi;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ponsun.aml.banktransaction.AuditLog.domain.AuditLog;
import com.ponsun.aml.banktransaction.AuditLog.request.CreateAuditLogRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommonReadDTO {

    private List<AuditLog> auditLogs;

    public CommonReadDTO(List<AuditLog> auditLogs){
        this.auditLogs=auditLogs;
    }

    public static CommonReadDTO newInstance(List<AuditLog> auditLogs){
        return new CommonReadDTO(auditLogs);
    }
}
