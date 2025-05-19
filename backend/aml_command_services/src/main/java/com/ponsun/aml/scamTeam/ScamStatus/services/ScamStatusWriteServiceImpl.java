package com.ponsun.aml.scamTeam.ScamStatus.services;

import com.ponsun.aml.scamTeam.ScamStatus.data.ScamStatusData;
import com.ponsun.aml.scamTeam.ScamStatus.data.ScamStatusValidator;
import com.ponsun.aml.scamTeam.ScamStatus.domain.ScamStatus;
import com.ponsun.aml.scamTeam.ScamStatus.domain.ScamStatusRepository;
import com.ponsun.aml.scamTeam.ScamStatus.domain.ScamStatusWrapper;
import com.ponsun.aml.scamTeam.ScamStatus.request.CreateScamStatusRequest;
import com.ponsun.aml.scamTeam.ScamStatus.request.UpdateScamStatusRequest;
import com.ponsun.aml.scamTeam.ScamStatus.rowmapper.ScamStatusRowMapper;
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
public class ScamStatusWriteServiceImpl implements ScamStatusWriteService {
    private final ScamStatusRepository scamStatusRepository;
    private final ScamStatusWrapper scamStatusWrapper;
    private final ScamStatusValidator scamStatusValidator;
    private final ScamStatusRowMapper scamStatusRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createScamStatus(CreateScamStatusRequest createScamStatusRequest) {
        try {
            this.scamStatusValidator.validateSaveStatus(createScamStatusRequest);
            final ScamStatus scamStatus = ScamStatus.create(createScamStatusRequest);
            this.scamStatusRepository.saveAndFlush(scamStatus);
            return Response.of(Long.valueOf(scamStatus.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateScamStatus(Integer id, UpdateScamStatusRequest updateScamStatusRequest) {
        try {
            this.scamStatusValidator.validateUpdateStatus(updateScamStatusRequest);
            final ScamStatus scamStatus = this.scamStatusWrapper.findOneWithNotFoundDetection(id);
            scamStatus.update(updateScamStatusRequest);
            this.scamStatusRepository.saveAndFlush(scamStatus);
            return Response.of(Long.valueOf(scamStatus.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    public List<ScamStatusData> fetchAllScamStatusData(Integer scamId) {
        final ScamStatusRowMapper rowMapper = new ScamStatusRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE ss.scamId = ?  AND ss.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<ScamStatusData> scamStatusData = jdbcTemplate.query(Qry, scamStatusRowMapper, new Object[]{scamId});
        return scamStatusData;
    }

    @Override
    @Transactional
    public Response deActive(Integer scamId, Integer euid) {
        try {
            List<ScamStatus> scamStatuses = this.scamStatusWrapper.findScamIdNotFoundDetection(scamId);
            Response response = null;
            for (ScamStatus scamStatus : scamStatuses) {
                scamStatus.setEuid(euid);
                scamStatus.setStatus(Status.DELETE);
                scamStatus.setUpdatedAt(LocalDateTime.now());
                response = Response.of(scamStatus.getId());
            }
            return response;
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
}
