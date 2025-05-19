package com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmodule.data;


import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmodule.request.CreateAdminConfigModuleRequest;
import com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmodule.request.UpdateAdminConfigModuleRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminConfigModuleDataValidator {
    public void validateSaveAdminConfigModule(final CreateAdminConfigModuleRequest request) throws AppicationException {
        if (request.getName() == null || request.getName().equals("")) {
            throw new AppicationException("AdminConfigModuleName parameter required");
        }
    }
    public void validateUpdateAdminConfigModule(final UpdateAdminConfigModuleRequest request) throws AppicationException {
        if (request.getName() == null || request.getName().equals("")) {
            throw new AppicationException("AdminConfigModuleName parameter required");
        }
    }
}
