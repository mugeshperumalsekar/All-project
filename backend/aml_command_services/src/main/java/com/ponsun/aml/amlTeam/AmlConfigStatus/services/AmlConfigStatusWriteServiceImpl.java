package com.ponsun.aml.amlTeam.AmlConfigStatus.services;

import com.ponsun.aml.amlTeam.AmlConfigStatus.data.AmlConfigStatusValidator;
import com.ponsun.aml.amlTeam.AmlConfigStatus.domain.AmlConfigStatus;
import com.ponsun.aml.amlTeam.AmlConfigStatus.domain.AmlConfigStatusRepository;
import com.ponsun.aml.amlTeam.AmlConfigStatus.domain.AmlConfigStatusWrapper;
import com.ponsun.aml.amlTeam.AmlConfigStatus.request.CreateAmlConfigStatusRequest;
import com.ponsun.aml.amlTeam.AmlConfigStatus.request.UpdateAmlConfigStatusRequest;
import com.ponsun.aml.amlTeam.AmlConfigStatus.rowmapper.AmlConfigStatusRowMapper;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import com.ponsun.aml.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AmlConfigStatusWriteServiceImpl implements AmlConfigStatusWriteService {
    private final AmlConfigStatusRepository amlConfigStatusRepository;
    private final AmlConfigStatusWrapper amlConfigStatusWrapper;
    private final AmlConfigStatusValidator amlConfigStatusValidator;
    private final AmlConfigStatusRowMapper amlConfigStatusRowMapper;
    private final JdbcTemplate jdbcTemplate;
    
    @Override
    @Transactional
    public Response createAmlConfigStatus(CreateAmlConfigStatusRequest createAmlConfigStatusRequest){
        try{
            this.amlConfigStatusValidator.validateSaveConfigStatus(createAmlConfigStatusRequest);
            final AmlConfigStatus amlConfigStatus = AmlConfigStatus.create(createAmlConfigStatusRequest);
            this.amlConfigStatusRepository.saveAndFlush(amlConfigStatus);
            return Response.of(Long.valueOf(amlConfigStatus.getId()));
        } catch (DataIntegrityViolationException e){
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateAmlConfigStatus(Integer id,UpdateAmlConfigStatusRequest updateAmlConfigStatusRequest){
        try{
            this.amlConfigStatusValidator.validateUpdateConfigStatus(updateAmlConfigStatusRequest);
            final AmlConfigStatus amlConfigStatus = this.amlConfigStatusWrapper.findOneWithNotFoundDetection(id);
            amlConfigStatus.update(updateAmlConfigStatusRequest);
            this.amlConfigStatusRepository.saveAndFlush(amlConfigStatus);
            return Response.of(Long.valueOf(amlConfigStatus.getId()));
        }catch (DataIntegrityViolationException e){
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
}
