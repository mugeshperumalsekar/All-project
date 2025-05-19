package com.ponsun.aml.counterfeit.CounterfeitNumber.services;

import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.counterfeit.CounterfeitNumber.data.CounterfeitNumberData;
import com.ponsun.aml.counterfeit.CounterfeitNumber.rowmapper.CounterfeitNumberRowMapper;
import com.ponsun.aml.counterfeit.CounterfeitNumber.domain.CounterfeitNumber;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import com.ponsun.aml.infrastructure.utils.Response;
import com.ponsun.aml.counterfeit.CounterfeitNumber.data.CounterfeitNumberValidator;
import com.ponsun.aml.counterfeit.CounterfeitNumber.domain.CounterfeitNumberRepository;
import com.ponsun.aml.counterfeit.CounterfeitNumber.domain.CounterfeitNumberWrapper;
import com.ponsun.aml.counterfeit.CounterfeitNumber.request.CreateCounterfeitNumberRequest;
import com.ponsun.aml.counterfeit.CounterfeitNumber.request.UpdateCounterfeitNumberRequest;
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
public class CounterfeitNumberWriteServiceImpl implements CounterfeitNumberWriteService {

        private final CounterfeitNumberRepository counterfeitNumberRepository;
        private final CounterfeitNumberWrapper counterfeitNumberWrapper;
        private final CounterfeitNumberValidator counterfeitNumberValidator;
        private final CounterfeitNumberRowMapper counterfeitNumberRowMapper;
        private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createCounterfeitNumber(CreateCounterfeitNumberRequest createCounterfeitNumberRequest) {
        try {
            this.counterfeitNumberValidator.validateSaveCounterfeitNumber(createCounterfeitNumberRequest);
            final CounterfeitNumber counterfeitNumber = CounterfeitNumber.create(createCounterfeitNumberRequest);//entity
            this.counterfeitNumberRepository.saveAndFlush(counterfeitNumber);
            return Response.of(Long.valueOf(counterfeitNumber.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateCounterfeitNumber(Integer id, UpdateCounterfeitNumberRequest updateCounterfeitNumberRequest) {
        try {
            this.counterfeitNumberValidator.validateUpdateCounterfeitNumber(updateCounterfeitNumberRequest);
            final CounterfeitNumber counterfeitNumber = this.counterfeitNumberWrapper.findOneWithNotFoundDetection(id);
            counterfeitNumber.update(updateCounterfeitNumberRequest);
            this.counterfeitNumberRepository.saveAndFlush(counterfeitNumber);
            return Response.of(Long.valueOf(counterfeitNumber.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    public List<CounterfeitNumberData> fetchAllCounterfeitNumberData(Integer counterfeitId) {
        final CounterfeitNumberRowMapper rowMapper = new CounterfeitNumberRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE cn.counterfeitId = ?  AND cn.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<CounterfeitNumberData> counterfeitStatusData  = jdbcTemplate.query(Qry,counterfeitNumberRowMapper,
                new Object[] {counterfeitId}
        );
        return counterfeitStatusData;
    }

    @Override
    @Transactional
    public Response deActive(Integer counterfeitId, Integer euid){
        try{
            List<CounterfeitNumber> counterfeitNumbers = this.counterfeitNumberWrapper.findCounterfeitIdNotFoundDetection(counterfeitId);
            Response response = null;
            for (CounterfeitNumber counterfeitNumber : counterfeitNumbers) {
                counterfeitNumber.setEuid(euid);
                counterfeitNumber.setStatus(Status.DELETE);
                counterfeitNumber.setUpdatedAt(LocalDateTime.now());
                response = Response.of(counterfeitNumber.getId());
            }
            return response;
        }catch (DataIntegrityViolationException e){
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
}
