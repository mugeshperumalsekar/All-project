package com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.services;

import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.request.CreateAmlComplaintAlertScenariosRequest;
import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.request.UpdateAmlComplaintAlertScenariosRequest;
import com.ponsun.aml.infrastructure.utils.Response;

public interface AmlComplaintAlertScenariosWriteService {
    Response createAlertScenariosList(CreateAmlComplaintAlertScenariosRequest createAmlComplaintAlertScenariosRequest);
    Response updateAlertScenariosList(Integer id, UpdateAmlComplaintAlertScenariosRequest updateAmlComplaintAlertScenariosRequest);

}
