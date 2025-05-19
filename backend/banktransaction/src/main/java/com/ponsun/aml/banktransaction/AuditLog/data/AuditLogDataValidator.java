package com.ponsun.aml.banktransaction.AuditLog.data;


import com.ponsun.aml.banktransaction.AuditLog.request.CreateAuditLogRequest;
import com.ponsun.aml.banktransaction.AuditLog.request.UpdateAuditLogRequest;
import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
@Slf4j
@Service
public class AuditLogDataValidator {
    public void validateSaveAuditLog(final CreateAuditLogRequest request) throws AppicationException {
        if(request.getName() == null || request.getName().equals("")){
            throw new AppicationException("Name parameter required");
        }
    }
    public void validateUpdateAuditLog(final UpdateAuditLogRequest request) throws AppicationException {
        if(request.getName() == null || request.getName().equals("")){
            throw new AppicationException("Name parameter required");
        }
    }
}
