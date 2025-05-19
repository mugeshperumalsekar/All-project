package com.ponsun.aml.adminconfiguration.adminconfigmoduledet.data;


import com.ponsun.aml.adminconfiguration.adminconfigmoduledet.request.CreateAdminConfigModuleDetRequest;
import com.ponsun.aml.adminconfiguration.adminconfigmoduledet.request.UpdateAdminConfigModuleDetRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdminConfigModuleDetDataValidator {
    public void validateSaveModuleDet(final CreateAdminConfigModuleDetRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_AML_AppicationException("ModuleName parameter required");
        }
    }
    public void validateUpdateModuleDet(final UpdateAdminConfigModuleDetRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_AML_AppicationException("ModuleName parameter required");
        }
    }
}