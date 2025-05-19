package com.ponsun.aml.fraudTeam.FraudObservation.services;

import com.ponsun.aml.fraudTeam.FraudObservation.data.FraudObservationData;
import com.ponsun.aml.fraudTeam.FraudObservation.data.FraudObservationValidator;
import com.ponsun.aml.fraudTeam.FraudObservation.domain.FraudObservation;
import com.ponsun.aml.fraudTeam.FraudObservation.domain.FraudObservationRepository;
import com.ponsun.aml.fraudTeam.FraudObservation.domain.FraudObservationWrapper;
import com.ponsun.aml.fraudTeam.FraudObservation.request.CreateFraudObservationRequest;
import com.ponsun.aml.fraudTeam.FraudObservation.request.UpdateFraudObservationRequest;
import com.ponsun.aml.fraudTeam.FraudObservation.rowmapper.FraudObservationRowMapper;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import com.ponsun.aml.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDateTime;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class FraudObservationWriteServiceImpl implements FraudObservationWriteService {
    private final FraudObservationRepository fraudObservationRepository;
    private final FraudObservationWrapper fraudObservationWrapper;
    private final FraudObservationValidator fraudObservationValidator;
    private final FraudObservationRowMapper fraudObservationRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createFraudObservation(CreateFraudObservationRequest createFraudObservationRequest){
        try {
            this.fraudObservationValidator.validateSaveObservation(createFraudObservationRequest);
            final FraudObservation fraudObservation = FraudObservation.create(createFraudObservationRequest);
            this.fraudObservationRepository.saveAndFlush(fraudObservation);
            return Response.of(Long.valueOf(fraudObservation.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateFraudObservation(Integer id, UpdateFraudObservationRequest updateFraudObservationRequest){
        try {
            this.fraudObservationValidator.validateUpdateObservation(updateFraudObservationRequest);
            final FraudObservation fraudObservation = this.fraudObservationWrapper.findOneWithNotFoundDetection(id);
            fraudObservation.update(updateFraudObservationRequest);
            this.fraudObservationRepository.saveAndFlush(fraudObservation);
            return Response.of(Long.valueOf(fraudObservation.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    public List<FraudObservationData> fetchAllFraudObservationData(Integer fraudId){
        final FraudObservationRowMapper rowMapper = new FraudObservationRowMapper();
        String Qry ="SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE fo.fraudId = ?  AND fo.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<FraudObservationData> fraudObservationData = jdbcTemplate.query(Qry, fraudObservationRowMapper,new Object[]{fraudId});
        return fraudObservationData;
    }
    @Override
    @Transactional
    public Response deActive(Integer fraudId,Integer euid){
        try{
            List<FraudObservation> fraudObservations = this.fraudObservationWrapper.findFraudIdNotFoundDetection(fraudId);
            Response response = null;
            for(FraudObservation fraudObservation : fraudObservations){
                fraudObservation.setEuid(euid);
                fraudObservation.setStatus(Status.DELETE);
                fraudObservation.setUpdatedAt(LocalDateTime.now());
                response = Response.of(fraudObservation.getId());
            }
            return response;
        }catch (DataIntegrityViolationException e){
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
}
