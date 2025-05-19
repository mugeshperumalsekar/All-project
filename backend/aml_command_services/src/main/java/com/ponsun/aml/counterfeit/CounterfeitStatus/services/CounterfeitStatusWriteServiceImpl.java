package com.ponsun.aml.counterfeit.CounterfeitStatus.services;

import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.counterfeit.CounterfeitStatus.data.CounterfeitStatusData;
import com.ponsun.aml.counterfeit.CounterfeitStatus.rowmapper.CounterfeitStatusRowMapper;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import com.ponsun.aml.infrastructure.utils.Response;
import com.ponsun.aml.counterfeit.CounterfeitStatus.data.CounterfeitStatusValidator;
import com.ponsun.aml.counterfeit.CounterfeitStatus.domain.CounterfeitStatus;
import com.ponsun.aml.counterfeit.CounterfeitStatus.domain.CounterfeitStatusRepository;
import com.ponsun.aml.counterfeit.CounterfeitStatus.domain.CounterfeitStatusWrapper;
import com.ponsun.aml.counterfeit.CounterfeitStatus.request.CreateCounterfeitStatusRequest;
import com.ponsun.aml.counterfeit.CounterfeitStatus.request.UpdateCounterfeitStatusRequest;
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
public class CounterfeitStatusWriteServiceImpl implements  CounterfeitStatusWriteService {
    private final CounterfeitStatusRepository CounterfeitStatusRepository;
    private final CounterfeitStatusWrapper CounterfeitStatusWrapper;
    private final CounterfeitStatusValidator CounterfeitStatusValidator;
    private final CounterfeitStatusRowMapper counterfeitStatusRowMapper;
    private final JdbcTemplate jdbcTemplate;
    @Override
    @Transactional
    public Response createCounterfeitStatus(CreateCounterfeitStatusRequest createCounterfeitStatusRequest) {
        try {
            this.CounterfeitStatusValidator.validateSaveCounterfeitStatus(createCounterfeitStatusRequest);
            final CounterfeitStatus counterfeitStatus = CounterfeitStatus.create(createCounterfeitStatusRequest);//entity
            this.CounterfeitStatusRepository.saveAndFlush(counterfeitStatus);
            return Response.of(Long.valueOf(counterfeitStatus.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateCounterfeitStatus(Integer id, UpdateCounterfeitStatusRequest updateCounterfeitStatusRequest) {
        try {
            this.CounterfeitStatusValidator.validateUpdateCounterfeitStatus(updateCounterfeitStatusRequest);
            final CounterfeitStatus counterfeitStatus = this.CounterfeitStatusWrapper.findOneWithNotFoundDetection(id);
            counterfeitStatus.update(updateCounterfeitStatusRequest);
            this.CounterfeitStatusRepository.saveAndFlush(counterfeitStatus);
            return Response.of(Long.valueOf(counterfeitStatus.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    public List<CounterfeitStatusData> fetchAllCounterfeitStatusData(Integer counterfeitId) {
        final CounterfeitStatusRowMapper rowMapper = new CounterfeitStatusRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE cs.counterfeitId = ?  AND cs.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<CounterfeitStatusData> counterfeitStatusData  = jdbcTemplate.query(Qry,counterfeitStatusRowMapper,
                new Object[] {counterfeitId}
        );
        return counterfeitStatusData;
    }


    @Override
    @Transactional
    public Response deActive(Integer counterfeitId, Integer euid){
        try{
            List<CounterfeitStatus> counterfeitStatuses = this.CounterfeitStatusWrapper.findCounterfeitIdNotFoundDetection(counterfeitId);
            Response response = null;
            for (CounterfeitStatus counterfeitStatus : counterfeitStatuses) {
                counterfeitStatus.setEuid(euid);
                counterfeitStatus.setStatus(Status.DELETE);
                counterfeitStatus.setUpdatedAt(LocalDateTime.now());
                response = Response.of(counterfeitStatus.getId());
            }
            return response;
        }catch (DataIntegrityViolationException e){
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
}