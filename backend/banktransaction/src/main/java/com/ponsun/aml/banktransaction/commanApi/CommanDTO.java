package com.ponsun.aml.banktransaction.commanApi;

import com.ponsun.aml.banktransaction.AuditLog.request.CreateAuditLogRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Data
public class CommanDTO {
    private CreateAuditLogRequest createAuditLogRequest;
public  CommanDTO(CreateAuditLogRequest createAuditLogRequest){
    this.createAuditLogRequest=createAuditLogRequest;
}
public static CommanDTO newInstance(CreateAuditLogRequest createAuditLogRequest){
    return new CommanDTO(createAuditLogRequest);
}
}
