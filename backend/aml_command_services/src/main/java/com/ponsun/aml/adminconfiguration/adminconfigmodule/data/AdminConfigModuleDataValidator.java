package com.ponsun.aml.adminconfiguration.adminconfigmodule.data;


import com.ponsun.aml.adminconfiguration.adminconfigmodule.request.CreateAdminConfigModuleRequest;
import com.ponsun.aml.adminconfiguration.adminconfigmodule.request.UpdateAdminConfigModuleRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminConfigModuleDataValidator {
    public void validateSaveAdminConfigModule(final CreateAdminConfigModuleRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_AML_AppicationException("AdminConfigModuleName parameter required");
        }
    }
    public void validateUpdateAdminConfigModule(final UpdateAdminConfigModuleRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_AML_AppicationException("AdminConfigModuleName parameter required");
        }
    }
}
