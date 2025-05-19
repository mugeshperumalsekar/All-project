package com.ponsun.aml.amlTeam.BranchUserMapping.data;

import com.ponsun.aml.amlTeam.BranchUserMapping.request.CreateBranchUserMappingRequest;
import com.ponsun.aml.amlTeam.BranchUserMapping.request.UpdateBranchUserMappingRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BranchUserMappingValidator {
    public void validateSaveBranchUserMapping(final CreateBranchUserMappingRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
    public void validateUpdateBranchUserMapping(final UpdateBranchUserMappingRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }


}
