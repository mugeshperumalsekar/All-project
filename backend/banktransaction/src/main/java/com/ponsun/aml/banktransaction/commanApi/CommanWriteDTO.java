package com.ponsun.aml.banktransaction.commanApi;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ponsun.aml.banktransaction.AuditLog.request.CreateAuditLogRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class CommanWriteDTO {

    private CreateAuditLogRequest createAuditLogRequest;

    public CommanWriteDTO(CreateAuditLogRequest createAuditLogRequest){
        this.createAuditLogRequest=createAuditLogRequest;
    }

    public static CommanWriteDTO newInstance(CreateAuditLogRequest createAuditLogRequest){
        return new CommanWriteDTO (createAuditLogRequest);
    }
}
