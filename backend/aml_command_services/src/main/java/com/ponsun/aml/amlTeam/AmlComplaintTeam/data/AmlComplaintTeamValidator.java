package com.ponsun.aml.amlTeam.AmlComplaintTeam.data;

import com.ponsun.aml.amlTeam.AmlComplaintTeam.request.CreateAmlComplaintTeamRequest;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.request.UpdateAmlComplaintTeamRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AmlComplaintTeamValidator {
    public void validateSaveAmlBranchList(final CreateAmlComplaintTeamRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
    public void validateUpdateAmlBranchList(final UpdateAmlComplaintTeamRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }

}
