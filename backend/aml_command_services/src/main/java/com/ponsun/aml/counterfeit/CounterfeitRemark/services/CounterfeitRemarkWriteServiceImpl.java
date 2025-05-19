package com.ponsun.aml.counterfeit.CounterfeitRemark.services;


import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.counterfeit.CounterfeitRemark.data.CounterfeitRemarkData;
import com.ponsun.aml.counterfeit.CounterfeitRemark.rowmapper.CounterfeitRemarkRowMapper;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import com.ponsun.aml.infrastructure.utils.Response;
import com.ponsun.aml.counterfeit.CounterfeitRemark.data.CounterfeitRemarkValidator;
import com.ponsun.aml.counterfeit.CounterfeitRemark.domain.CounterfeitRemark;
import com.ponsun.aml.counterfeit.CounterfeitRemark.domain.CounterfeitRemarkRepository;
import com.ponsun.aml.counterfeit.CounterfeitRemark.domain.CounterfeitRemarkWrapper;
import com.ponsun.aml.counterfeit.CounterfeitRemark.request.CreateCounterfeitRemarkRequest;
import com.ponsun.aml.counterfeit.CounterfeitRemark.request.UpdateCounterfeitRemarkRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CounterfeitRemarkWriteServiceImpl implements CounterfeitRemarkWriteService{

    private final CounterfeitRemarkRepository counterfeitRemarkRepository;
    private final CounterfeitRemarkWrapper counterfeitRemarkWrapper;
    private final CounterfeitRemarkValidator counterfeitRemarkValidator;
    private final CounterfeitRemarkRowMapper counterfeitRemarkRowMapper;
    private final JdbcTemplate jdbcTemplate;
    @Override
    @Transactional
    public Response createCounterfeitRemark(CreateCounterfeitRemarkRequest createCounterfeitRemarkRequest) {
        try {
            this.counterfeitRemarkValidator.validateSaveCounterfeitRemark(createCounterfeitRemarkRequest);
            final CounterfeitRemark counterfeitRemark = CounterfeitRemark.create(createCounterfeitRemarkRequest);//entity
            this.counterfeitRemarkRepository.saveAndFlush(counterfeitRemark);
            return Response.of(Long.valueOf(counterfeitRemark.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateCounterfeitRemark(Integer id, UpdateCounterfeitRemarkRequest updateCounterfeitRemarkRequest) {
        try {
            this.counterfeitRemarkValidator.validateUpdateCounterfeitRemark(updateCounterfeitRemarkRequest);
            final CounterfeitRemark counterfeitRemark = this.counterfeitRemarkWrapper.findOneWithNotFoundDetection(id);
            counterfeitRemark.update(updateCounterfeitRemarkRequest);
            this.counterfeitRemarkRepository.saveAndFlush(counterfeitRemark);
            return Response.of(Long.valueOf(counterfeitRemark.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    public List<CounterfeitRemarkData> fetchAllCounterfeitRemarkData(Integer counterfeitId) {
        final CounterfeitRemarkRowMapper rowMapper = new CounterfeitRemarkRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE cr.counterfeitId = ?  AND cr.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<CounterfeitRemarkData> dateOfBirthDTOList  = jdbcTemplate.query(Qry,counterfeitRemarkRowMapper,
                new Object[] {counterfeitId}
        );
        return dateOfBirthDTOList;
    }


    @Override
    @Transactional
    public Response deActive(Integer counterfeitId, Integer euid){
        try{
            List<CounterfeitRemark> counterfeitRemarks = this.counterfeitRemarkWrapper.findCounterfeitIdNotFoundDetection(counterfeitId);
            Response response = null;
            for (CounterfeitRemark counterfeitRemark : counterfeitRemarks) {
                counterfeitRemark.setEuid(euid);
                counterfeitRemark.setStatus(Status.DELETE);
                counterfeitRemark.setUpdatedAt(LocalDateTime.now());
                response = Response.of(counterfeitRemark.getId());
            }
            return response;
        }catch (DataIntegrityViolationException e){
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
}
