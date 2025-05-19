package com.ponsun.aml.counterfeit.CounterfeitTeam.services;

import com.ponsun.aml.amlTeam.AmlComplaintTeam.domain.AmlComplaintTeam;
import com.ponsun.aml.counterfeit.CounterfeitTeam.data.CounterfeitTeamData;
import com.ponsun.aml.counterfeit.CounterfeitTeam.romapper.CounterfeitTeamRowMapper;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import com.ponsun.aml.infrastructure.utils.Response;
import com.ponsun.aml.counterfeit.CounterfeitTeam.data.CounterfeitTeamValidator;
import com.ponsun.aml.counterfeit.CounterfeitTeam.domain.CounterfeitTeam;
import com.ponsun.aml.counterfeit.CounterfeitTeam.domain.CounterfeitTeamRepository;
import com.ponsun.aml.counterfeit.CounterfeitTeam.domain.CounterfeitTeamWrapper;
import com.ponsun.aml.counterfeit.CounterfeitTeam.request.CreateCounterfeitTeamRequest;
import com.ponsun.aml.counterfeit.CounterfeitTeam.request.UpdateCounterfeitTeamRequest;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CounterfeitTeamWriteServiceImpl implements CounterfeitTeamWriteService{
    private final CounterfeitTeamRepository counterfeitTeamRepository;
    private final CounterfeitTeamWrapper counterfeitTeamWrapper;
    private final CounterfeitTeamValidator counterfeitTeamValidator;
    private final CounterfeitTeamRowMapper counterfeitTeamRowMapper;
    private final JdbcTemplate jdbcTemplate;
    private final CounterfeitTeamReadService counterfeitTeamReadService;
    @Override
    @Transactional
    public Response createCounterfeitTeam(CreateCounterfeitTeamRequest createCounterfeitTeamRequest) {
        try {
            this.counterfeitTeamValidator.validateSaveCounterfeitTeam(createCounterfeitTeamRequest);
            if (createCounterfeitTeamRequest.getTicketId() == 0)
                createCounterfeitTeamRequest.setTicketId(counterfeitTeamReadService.getmaxTicketId());
            final CounterfeitTeam counterfeitTeam = CounterfeitTeam.create(createCounterfeitTeamRequest);//entity
            this.counterfeitTeamRepository.saveAndFlush(counterfeitTeam);
            return Response.of(Long.valueOf(counterfeitTeam.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateCounterfeitTeam(Integer id, UpdateCounterfeitTeamRequest updateCounterfeitTeamRequest) {
        try {
            this.counterfeitTeamValidator.validateUpdateCounterfeitTeam(updateCounterfeitTeamRequest);
            final CounterfeitTeam counterfeitTeam = this.counterfeitTeamWrapper.findOneWithNotFoundDetection(id);
            counterfeitTeam.update(updateCounterfeitTeamRequest);
            this.counterfeitTeamRepository.saveAndFlush(counterfeitTeam);
            return Response.of(Long.valueOf(counterfeitTeam.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    public List<CounterfeitTeamData> fetchAllCounterfeitTeamData(Integer id) {
        final CounterfeitTeamRowMapper rowMapper = new CounterfeitTeamRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE ct.id = ?  AND ct.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<CounterfeitTeamData> counterfeitTeamData  = jdbcTemplate.query(Qry,counterfeitTeamRowMapper,
                new Object[] {id}
        );
        return counterfeitTeamData;
    }

}
