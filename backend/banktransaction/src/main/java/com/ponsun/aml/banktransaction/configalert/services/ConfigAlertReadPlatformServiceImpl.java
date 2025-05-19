package com.ponsun.aml.banktransaction.configalert.services;

import com.ponsun.aml.banktransaction.configalert.domain.ConfigAlert;
import com.ponsun.aml.banktransaction.configalert.domain.ConfigAlertRepositoryWrapper;
import com.ponsun.aml.banktransaction.configalert.domain.ConfigAlertRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConfigAlertReadPlatformServiceImpl implements ConfigAlertReadPlatformService {

    private final ConfigAlertRepositoryWrapper alertRepositoryWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final ConfigAlertRepository configAlertRepository;
    @Override
    public ConfigAlert fetchAlertById(Integer id){
        return this.configAlertRepository.findById(id).get();
    }
    @Override
    public List<ConfigAlert> fetchAllAlert(){ return this.configAlertRepository.findAll();}
}
