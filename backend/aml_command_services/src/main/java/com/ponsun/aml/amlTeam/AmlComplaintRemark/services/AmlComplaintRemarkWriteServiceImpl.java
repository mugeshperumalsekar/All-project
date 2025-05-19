package com.ponsun.aml.amlTeam.AmlComplaintRemark.services;

import com.ponsun.aml.amlTeam.AmlComplaintRemark.data.AmlComplaintRemarkValidator;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.domain.AmlComplaintRemark;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.domain.AmlComplaintRemarkRepository;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.domain.AmlComplaintRemarkWrapper;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.request.CreateAmlComplaintRemarkRequest;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.request.UpdateAmlComplaintRemarkRequest;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.rowmapper.AmlComplaintRemarkRowmapper;
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
public class AmlComplaintRemarkWriteServiceImpl implements AmlComplaintRemarkWriteService {
    private final AmlComplaintRemarkRepository amlComplaintRemarkRepository;
    private final AmlComplaintRemarkWrapper amlComplaintRemarkWrapper;
    private final AmlComplaintRemarkValidator amlComplaintRemarkValidator;
    private final AmlComplaintRemarkRowmapper amlComplaintRemarkRowmapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createAmlComplaintRemarkList(CreateAmlComplaintRemarkRequest createAmlComplaintRemarkRequest) {
        try {
            this.amlComplaintRemarkValidator.validateSaveAmlComplaintRemarkList(createAmlComplaintRemarkRequest);
            final AmlComplaintRemark amlComplaintRemark = AmlComplaintRemark.create(createAmlComplaintRemarkRequest);//entity
            this.amlComplaintRemarkRepository.saveAndFlush(amlComplaintRemark);
            return Response.of(Long.valueOf(amlComplaintRemark.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateAmlComplaintRemarkList(Integer id, UpdateAmlComplaintRemarkRequest updateAmlComplaintRemarkRequest) {
        try {
            this.amlComplaintRemarkValidator.validateUpdateAmlComplaintRemarkList(updateAmlComplaintRemarkRequest);
            final AmlComplaintRemark amlComplaintRemark = this.amlComplaintRemarkWrapper.findOneWithNotFoundDetection(id);
            amlComplaintRemark.update(updateAmlComplaintRemarkRequest);
            this.amlComplaintRemarkRepository.saveAndFlush(amlComplaintRemark);
            return Response.of(Long.valueOf(amlComplaintRemark.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
}