package com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.services;

import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.request.CreateAbstractAmlConfigAlertScenariosRequest;
import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.request.UpdateAbstractAmlConfigAlertScenariosRequest;
import com.ponsun.aml.infrastructure.utils.Response;

public interface AmlConfigAlertScenariosWriteService {
    Response createAlertScenariosList(CreateAbstractAmlConfigAlertScenariosRequest createAlertScenariosRequest);
    Response updateAlertScenariosList(Integer id, UpdateAbstractAmlConfigAlertScenariosRequest updateAlertScenariosRequest);
}
