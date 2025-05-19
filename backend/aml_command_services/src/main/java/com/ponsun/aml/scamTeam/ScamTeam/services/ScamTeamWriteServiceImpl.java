package com.ponsun.aml.scamTeam.ScamTeam.services;

import com.ponsun.aml.scamTeam.ScamTeam.data.ScamTeamData;
import com.ponsun.aml.scamTeam.ScamTeam.data.ScamTeamValidator;
import com.ponsun.aml.scamTeam.ScamTeam.domain.ScamTeam;
import com.ponsun.aml.scamTeam.ScamTeam.domain.ScamTeamRepository;
import com.ponsun.aml.scamTeam.ScamTeam.domain.ScamTeamWrapper;
import com.ponsun.aml.scamTeam.ScamTeam.request.CreateScamTeamRequest;
import com.ponsun.aml.scamTeam.ScamTeam.request.UpdateScamTeamRequest;
import com.ponsun.aml.scamTeam.ScamTeam.rowmapper.ScamTeamRowMapper;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import com.ponsun.aml.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class ScamTeamWriteServiceImpl implements ScamTeamWriteService {
    private final ScamTeamRepository scamTeamRepository;
    private final ScamTeamWrapper scamTeamWrapper;
    private final ScamTeamValidator scamTeamValidator;
    private final ScamTeamRowMapper scamTeamRowMapper;
    private final JdbcTemplate jdbcTemplate;
    private final ScamTeamReadService scamTeamReadService;

    @Override
    @Transactional
    public Response createScamTeam(CreateScamTeamRequest createScamTeamRequest) {
        try {
            this.scamTeamValidator.validateSaveTeam(createScamTeamRequest);
            if (createScamTeamRequest.getTicketId() == 0)
                createScamTeamRequest.setTicketId(scamTeamReadService.getmaxTicketId());
            final ScamTeam scamTeam = ScamTeam.create(createScamTeamRequest);
            this.scamTeamRepository.saveAndFlush(scamTeam);
            return Response.of(Long.valueOf(scamTeam.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateScamTeam(Integer id, UpdateScamTeamRequest updateScamTeamRequest) {
        try {
            this.scamTeamValidator.validateUpdateTeam(updateScamTeamRequest);
            final ScamTeam scamTeam = this.scamTeamWrapper.findOneWithNotFoundDetection(id);
            scamTeam.update(updateScamTeamRequest);
            this.scamTeamRepository.saveAndFlush(scamTeam);
            return Response.of(Long.valueOf(scamTeam.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    public List<ScamTeamData> fetchAllScamTeamData(Integer id) {
        final ScamTeamRowMapper rowMapper = new ScamTeamRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE st.id = ?  AND st.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<ScamTeamData> scamTeamData = jdbcTemplate.query(Qry, scamTeamRowMapper, new Object[]{id});
        return scamTeamData;
    }
}
