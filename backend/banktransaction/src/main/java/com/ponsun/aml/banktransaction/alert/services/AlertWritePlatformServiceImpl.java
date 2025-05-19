package com.ponsun.aml.banktransaction.alert.services;

import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.alert.data.AlertDataValidator;
import com.ponsun.aml.banktransaction.alert.domain.Alert;
import com.ponsun.aml.banktransaction.alert.domain.AlertRepository;
import com.ponsun.aml.banktransaction.alert.domain.AlertRepositoryWrapper;
import com.ponsun.aml.banktransaction.alert.request.CreateAlertRequest;
import com.ponsun.aml.banktransaction.alert.request.UpdateAlertRequest;
import com.ponsun.aml.banktransaction.alert.rowmapper.AlertRowMapper;
import com.ponsun.aml.banktransaction.common.entity.Status;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;
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
public class AlertWritePlatformServiceImpl implements AlertWritePlatformService {

    private final AlertRepository alertRepository;
    private final AlertRepositoryWrapper alertRepositoryWrapper;
    private final AlertDataValidator alertDataValidator;
    private final AlertRowMapper alertRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createAlert(CreateAlertRequest createAlertRequest) throws AppicationException {
        try{
            this.alertDataValidator.validateSaveAlertData(createAlertRequest);
            final Alert alert = Alert.create(createAlertRequest);
            this.alertRepository.saveAndFlush(alert);
            return Response.of(alert.getId());
        }catch (DataIntegrityViolationException e){
            throw new AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateAlert(Integer id, UpdateAlertRequest updateAlertRequest) throws AppicationException {
        try {
            this.alertDataValidator.validateUpdateAlertData(updateAlertRequest);
        final Alert alert = this.alertRepositoryWrapper.findOneWithNotFoundDetection(id);
            alert.update(updateAlertRequest);
            this.alertRepository.saveAndFlush(alert);
            return Response.of(alert.getId());
        } catch (DataIntegrityViolationException e) {
            throw new AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response blockAlert(Integer id) throws AppicationException {
        try{
            final Alert alert = this.alertRepositoryWrapper.findOneWithNotFoundDetection(id);
            alert.setStatus(Status.DELETE);
            alert.setUpdatedAt(LocalDateTime.now());
            this.alertRepository.saveAndFlush(alert);
            return Response.of(id);
        }catch (DataIntegrityViolationException e){
            throw new AppicationException(e.getMessage());
        }   
    }

    @Override
    @Transactional
    public Response unblockAlert(Integer id) throws AppicationException {
        try {
            final Alert alert = this.alertRepositoryWrapper.findOneWithNotFoundDetection(id);
            alert.setStatus(Status.ACTIVE);
            alert.setUpdatedAt(LocalDateTime.now());
            this.alertRepository.saveAndFlush(alert);
            return Response.of(id);
        } catch (DataIntegrityViolationException e){
            throw new AppicationException(e.getMessage());
        }
    }
}
