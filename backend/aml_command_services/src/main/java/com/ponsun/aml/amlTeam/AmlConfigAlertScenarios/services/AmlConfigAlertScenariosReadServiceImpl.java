package com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.services;

import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.domain.AmlConfigAlertScenarios;
import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.domain.AmlConfigAlertScenariosRepository;
import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.domain.AmlConfigAlertScenariosWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AmlConfigAlertScenariosReadServiceImpl implements AmlConfigAlertScenariosReadService {
    private final AmlConfigAlertScenariosWrapper alertScenariosWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final AmlConfigAlertScenariosRepository alertScenariosRepository;

    @Override
    public AmlConfigAlertScenarios fetchAlertScenariosById(Integer id){
        return this.alertScenariosRepository.findById(id).get();
    }
    @Override
    public List<AmlConfigAlertScenarios> fetchAllAlertScenarios(){
        return this.alertScenariosRepository.findAll();
    }
}


