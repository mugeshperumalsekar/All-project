package com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.services;

import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.domain.AmlComplaintAlertScenarios;

import java.util.List;

public interface AmlComplaintAlertScenariosReadServices {
    AmlComplaintAlertScenarios fetchAlertScenariosById(Integer id);
    List<AmlComplaintAlertScenarios> fetchAllAlertScenarios();


}
