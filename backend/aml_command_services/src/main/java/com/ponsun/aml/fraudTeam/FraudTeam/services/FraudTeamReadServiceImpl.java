package com.ponsun.aml.fraudTeam.FraudTeam.services;

import com.ponsun.aml.fraudTeam.FraudTeam.domain.FraudTeam;
import com.ponsun.aml.fraudTeam.FraudTeam.domain.FraudTeamRepository;
import com.ponsun.aml.fraudTeam.FraudTeam.domain.FraudTeamWrapper;
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
public class FraudTeamReadServiceImpl implements FraudTeamReadService {
    private final FraudTeamWrapper fraudTeamWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final FraudTeamRepository fraudTeamRepository;

    @Override
    public FraudTeam fetchFraudTeamById(Integer id){
        return this.fraudTeamRepository.findById(id).get();
    }
    @Override
    public List<FraudTeam> fetchAllFraudTeam(){return this.fraudTeamRepository.findAll();}

    @Override
    @Transactional
    public Integer getmaxTicketId() {
        Integer ticketId    = 0;
        try {
            String sql = "SELECT COUNT(ticketId)+1 FROM fraud_team";
            ticketId = jdbcTemplate.queryForObject(sql,new Object[]{}, Integer.class);
            return ticketId;
        } catch (DataAccessException e) {
            System.err.println("Error getTicketId: " + e.getMessage());
            e.printStackTrace();
        }
        return ticketId;
    }

}
