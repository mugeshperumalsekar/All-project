package com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.data;

import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.request.CreateAmlComplaintAlertScenariosRequest;
import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.request.UpdateAmlComplaintAlertScenariosRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AmlComplaintAlertScenariosValidator {
    public void validateSaveAlertScenariosList(final CreateAmlComplaintAlertScenariosRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
    public void validateUpdateAlertScenariosList(final UpdateAmlComplaintAlertScenariosRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }

}
