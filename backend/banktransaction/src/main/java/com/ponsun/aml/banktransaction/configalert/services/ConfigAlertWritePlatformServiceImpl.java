package com.ponsun.aml.banktransaction.configalert.services;

import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.common.entity.Status;
import com.ponsun.aml.banktransaction.configalert.domain.ConfigAlert;
import com.ponsun.aml.banktransaction.configalert.domain.ConfigAlertRepositoryWrapper;
import com.ponsun.aml.banktransaction.configalert.request.CreateConfigAlertRequest;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;
import com.ponsun.aml.banktransaction.configalert.data.ConfigAlertDataValidator;
import com.ponsun.aml.banktransaction.configalert.domain.ConfigAlertRepository;
import com.ponsun.aml.banktransaction.configalert.request.UpdateConfigAlertRequest;
import com.ponsun.aml.banktransaction.configalert.rowmapper.ConfigAlertRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
@Slf4j
public class ConfigAlertWritePlatformServiceImpl implements ConfigAlertWritePlatformService {

    private final ConfigAlertRepository configAlertRepository;
    private final ConfigAlertDataValidator configAlertDataValidator;

    @Override
    @Transactional
    public Response createAlert(CreateConfigAlertRequest createAlertRequest){
        try{
            this.configAlertDataValidator.validateSaveAlertData(createAlertRequest);
            final ConfigAlert configAlert = ConfigAlert.create(createAlertRequest);
            this.configAlertRepository.saveAndFlush(configAlert);
            return Response.of(configAlert.getId());
        } catch (AppicationException e) {
            throw new RuntimeException(e);
        }
    }
}
