package com.ponsun.aml.banktransaction.alert.services;

import com.ponsun.aml.banktransaction.alert.domain.Alert;
import com.ponsun.aml.banktransaction.alert.domain.AlertRepository;
import com.ponsun.aml.banktransaction.alert.domain.AlertRepositoryWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlertReadPlatformServiceImpl implements AlertReadPlatformService {

    private final AlertRepositoryWrapper alertRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final AlertRepository alertRepository;
    @Override
    public Alert fetchAlertById(Integer id){
        return this.alertRepository.findById(id).get();
    }
    @Override
    public List<Alert> fetchAllAlert(){ return this.alertRepository.findAll();}
}
