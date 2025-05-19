package com.ponsun.aml.banktransaction.adminconfiguration.admingroup.data;


import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.adminconfiguration.admingroup.request.CreateAdmingroupRequest;
import com.ponsun.aml.banktransaction.adminconfiguration.admingroup.request.UpdateAdmingroupRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdmingroupDataValidator {
    public void validateSaveAdmingroup(final CreateAdmingroupRequest request) throws AppicationException {
        if (request.getName() == null || request.getName().equals("")) {
            throw new AppicationException("ModuleName parameter required");
        }
    }
    public void validateUpdateAdmingroup(final UpdateAdmingroupRequest request) throws AppicationException {
        if (request.getName() == null || request.getName().equals("")) {
            throw new AppicationException("ModuleName parameter required");
        }
    }
}
