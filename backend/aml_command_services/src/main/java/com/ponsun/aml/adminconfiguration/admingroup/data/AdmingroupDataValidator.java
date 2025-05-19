package com.ponsun.aml.adminconfiguration.admingroup.data;


import com.ponsun.aml.adminconfiguration.admingroup.request.CreateAdmingroupRequest;
import com.ponsun.aml.adminconfiguration.admingroup.request.UpdateAdmingroupRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AdmingroupDataValidator {
    public void validateSaveAdmingroup(final CreateAdmingroupRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_AML_AppicationException("ModuleName parameter required");
        }
    }
    public void validateUpdateAdmingroup(final UpdateAdmingroupRequest request) {
        if (request.getName() == null || request.getName().equals("")) {
            throw new EQAS_AML_AppicationException("ModuleName parameter required");
        }
    }
}
