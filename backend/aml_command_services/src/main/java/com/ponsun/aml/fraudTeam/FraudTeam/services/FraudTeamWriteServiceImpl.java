package com.ponsun.aml.fraudTeam.FraudTeam.services;

import com.ponsun.aml.fraudTeam.FraudTeam.data.FraudTeamData;
import com.ponsun.aml.fraudTeam.FraudTeam.data.FraudTeamValidator;
import com.ponsun.aml.fraudTeam.FraudTeam.domain.FraudTeam;
import com.ponsun.aml.fraudTeam.FraudTeam.domain.FraudTeamRepository;
import com.ponsun.aml.fraudTeam.FraudTeam.domain.FraudTeamWrapper;
import com.ponsun.aml.fraudTeam.FraudTeam.request.CreateFraudTeamRequest;
import com.ponsun.aml.fraudTeam.FraudTeam.request.UpdateFraudTeamRequest;
import com.ponsun.aml.fraudTeam.FraudTeam.rowmapper.FraudTeamRowMapper;
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
public class FraudTeamWriteServiceImpl implements FraudTeamWriteService {
    private final FraudTeamRepository fraudTeamRepository;
    private final FraudTeamWrapper fraudTeamWrapper;
    private final FraudTeamValidator fraudTeamValidator;
    private final FraudTeamRowMapper fraudTeamRowMapper;
    private final JdbcTemplate jdbcTemplate;
    private final FraudTeamReadService fraudTeamReadService;

    @Override
    @Transactional
    public Response createFraudTeam(CreateFraudTeamRequest createFraudTeamRequest) {
        try {
            this.fraudTeamValidator.validateSaveTeam(createFraudTeamRequest);
            if (createFraudTeamRequest.getTicketId() == 0)
                createFraudTeamRequest.setTicketId(fraudTeamReadService.getmaxTicketId());
            final FraudTeam fraudTeam = FraudTeam.create(createFraudTeamRequest);
            this.fraudTeamRepository.saveAndFlush(fraudTeam);
            return Response.of(Long.valueOf(fraudTeam.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateFraudTeam(Integer id, UpdateFraudTeamRequest updateFraudTeamRequest) {
        try {
            this.fraudTeamValidator.validateUpdateTeam(updateFraudTeamRequest);
            final FraudTeam fraudTeam = this.fraudTeamWrapper.findOneWithNotFoundDetection(id);
            fraudTeam.update(updateFraudTeamRequest);
            this.fraudTeamRepository.saveAndFlush(fraudTeam);
            return Response.of(Long.valueOf(fraudTeam.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    public List<FraudTeamData> fetchAllFraudTeamData(Integer id) {
        final FraudTeamRowMapper rowMapper = new FraudTeamRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE ft.id = ?  AND ft.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<FraudTeamData> fraudTeamData = jdbcTemplate.query(Qry, fraudTeamRowMapper, new Object[]{id});
        return fraudTeamData;
    }
}
