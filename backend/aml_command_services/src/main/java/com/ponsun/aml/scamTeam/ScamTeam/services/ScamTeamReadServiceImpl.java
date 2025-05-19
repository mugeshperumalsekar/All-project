package com.ponsun.aml.scamTeam.ScamTeam.services;

import com.ponsun.aml.scamTeam.ScamTeam.domain.ScamTeam;
import com.ponsun.aml.scamTeam.ScamTeam.domain.ScamTeamRepository;
import com.ponsun.aml.scamTeam.ScamTeam.domain.ScamTeamWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScamTeamReadServiceImpl implements ScamTeamReadService {
    private final ScamTeamWrapper scamTeamWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final ScamTeamRepository scamTeamRepository;

    @Override
    public ScamTeam fetchScamTeamById(Integer id){
        return this.scamTeamRepository.findById(id).get();
    }
    @Override
    public List<ScamTeam> fetchAllScamTeam(){return this.scamTeamRepository.findAll();}

    @Override
    @Transactional
    public Integer getmaxTicketId() {
        Integer ticketId    = 0;
        try {
            String sql = "SELECT COUNT(ticketId)+1 FROM scam_team";
            ticketId = jdbcTemplate.queryForObject(sql,new Object[]{}, Integer.class);
            return ticketId;
        } catch (DataAccessException e) {
            System.err.println("Error getTicketId: " + e.getMessage());
            e.printStackTrace();
        }
        return ticketId;
    }

}
