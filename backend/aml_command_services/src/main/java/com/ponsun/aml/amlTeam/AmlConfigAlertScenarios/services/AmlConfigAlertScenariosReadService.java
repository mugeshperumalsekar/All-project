package com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.services;

import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.domain.AmlConfigAlertScenarios;

import java.util.List;

public interface AmlConfigAlertScenariosReadService {
    AmlConfigAlertScenarios fetchAlertScenariosById(Integer id);
    List<AmlConfigAlertScenarios> fetchAllAlertScenarios();
}
