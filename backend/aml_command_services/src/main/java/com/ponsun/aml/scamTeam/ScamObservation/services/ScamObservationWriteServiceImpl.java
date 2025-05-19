package com.ponsun.aml.scamTeam.ScamObservation.services;

import com.ponsun.aml.scamTeam.ScamObservation.data.ScamObservationData;
import com.ponsun.aml.scamTeam.ScamObservation.data.ScamObservationValidator;
import com.ponsun.aml.scamTeam.ScamObservation.domain.ScamObservation;
import com.ponsun.aml.scamTeam.ScamObservation.domain.ScamObservationRepository;
import com.ponsun.aml.scamTeam.ScamObservation.domain.ScamObservationWrapper;
import com.ponsun.aml.scamTeam.ScamObservation.request.CreateScamObservationRequest;
import com.ponsun.aml.scamTeam.ScamObservation.request.UpdateScamObservationRequest;
import com.ponsun.aml.scamTeam.ScamObservation.rowmapper.ScamObservationRowMapper;
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
public class ScamObservationWriteServiceImpl implements ScamObservationWriteService {
    private final ScamObservationRepository scamObservationRepository;
    private final ScamObservationWrapper scamObservationWrapper;
    private final ScamObservationValidator scamObservationValidator;
    private final ScamObservationRowMapper scamObservationRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createScamObservation(CreateScamObservationRequest createScamObservationRequest){
        try {
            this.scamObservationValidator.validateSaveObservation(createScamObservationRequest);
            final ScamObservation scamObservation = ScamObservation.create(createScamObservationRequest);
            this.scamObservationRepository.saveAndFlush(scamObservation);
            return Response.of(Long.valueOf(scamObservation.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateScamObservation(Integer id, UpdateScamObservationRequest updateScamObservationRequest){
        try {
            this.scamObservationValidator.validateUpdateObservation(updateScamObservationRequest);
            final ScamObservation ScamObservation = this.scamObservationWrapper.findOneWithNotFoundDetection(id);
            ScamObservation.update(updateScamObservationRequest);
            this.scamObservationRepository.saveAndFlush(ScamObservation);
            return Response.of(Long.valueOf(ScamObservation.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    public List<ScamObservationData> fetchAllScamObservationData(Integer scamId){
        final ScamObservationRowMapper rowMapper = new ScamObservationRowMapper();
        String Qry ="SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE so.scamId = ?  AND so.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<ScamObservationData> scamObservationData = jdbcTemplate.query(Qry, scamObservationRowMapper,new Object[]{scamId});
        return scamObservationData;
    }
    @Override
    @Transactional
    public Response deActive(Integer scamId,Integer euid){
        try{
            List<ScamObservation> scamObservations = this.scamObservationWrapper.findScamIdNotFoundDetection(scamId);
            Response response = null;
            for(ScamObservation scamObservation : scamObservations){
                scamObservation.setEuid(euid);
                scamObservation.setStatus(Status.DELETE);
                scamObservation.setUpdatedAt(LocalDateTime.now());
                response = Response.of(scamObservation.getId());
            }
            return response;
        }catch (DataIntegrityViolationException e){
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
}
