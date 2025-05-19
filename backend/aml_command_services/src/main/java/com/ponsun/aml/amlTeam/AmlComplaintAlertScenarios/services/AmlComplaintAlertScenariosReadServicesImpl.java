package com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.services;

import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.domain.AmlComplaintAlertScenarios;
import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.domain.AmlComplaintAlertScenariosRepository;
import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.domain.AmlComplaintAlertScenariosWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AmlComplaintAlertScenariosReadServicesImpl implements AmlComplaintAlertScenariosReadServices{
    private final AmlComplaintAlertScenariosWrapper amlComplaintAlertScenariosWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final AmlComplaintAlertScenariosRepository amlComplaintAlertScenariosRepository;

    @Override
    public AmlComplaintAlertScenarios fetchAlertScenariosById(Integer id){
        return this.amlComplaintAlertScenariosRepository.findById(id).get();
    }
    @Override
    public List<AmlComplaintAlertScenarios> fetchAllAlertScenarios(){
        return this.amlComplaintAlertScenariosRepository.findAll();
    }

}
