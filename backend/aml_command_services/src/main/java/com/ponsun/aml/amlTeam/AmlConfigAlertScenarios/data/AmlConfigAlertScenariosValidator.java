package com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.data;

import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.request.CreateAbstractAmlConfigAlertScenariosRequest;
import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.request.UpdateAbstractAmlConfigAlertScenariosRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AmlConfigAlertScenariosValidator {
    public void validateSaveAlertScenariosList(final CreateAbstractAmlConfigAlertScenariosRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }
    public void validateUpdateAlertScenariosList(final UpdateAbstractAmlConfigAlertScenariosRequest request) {
        if (request.getId() == null || request.getId().equals("")) {
            throw new EQAS_AML_AppicationException("id parameter required");
        }
    }

}
