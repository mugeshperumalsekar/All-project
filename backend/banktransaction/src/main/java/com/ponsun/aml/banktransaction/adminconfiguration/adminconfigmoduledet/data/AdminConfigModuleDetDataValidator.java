package com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmoduledet.data;


import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmoduledet.request.CreateAdminConfigModuleDetRequest;
import com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmoduledet.request.UpdateAdminConfigModuleDetRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminConfigModuleDetDataValidator {
    public void validateSaveModuleDet(final CreateAdminConfigModuleDetRequest request) throws AppicationException {
        if (request.getName() == null || request.getName().equals("")) {
            throw new AppicationException("ModuleName parameter required");
        }
    }
    public void validateUpdateModuleDet(final UpdateAdminConfigModuleDetRequest request) throws AppicationException {
        if (request.getName() == null || request.getName().equals("")) {
            throw new AppicationException("ModuleName parameter required");
        }
    }
}