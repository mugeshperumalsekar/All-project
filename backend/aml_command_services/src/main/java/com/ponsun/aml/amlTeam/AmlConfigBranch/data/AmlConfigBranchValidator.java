package com.ponsun.aml.amlTeam.AmlConfigBranch.data;
import com.ponsun.aml.amlTeam.AmlConfigBranch.request.CreateAmlConfigBranchRequest;
import com.ponsun.aml.amlTeam.AmlConfigBranch.request.UpdateAmlConfigBranchRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AmlConfigBranchValidator {
    public void validateSaveConfigBranch(final CreateAmlConfigBranchRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
    public void validateUpdateConfigBranch(final UpdateAmlConfigBranchRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }

}
