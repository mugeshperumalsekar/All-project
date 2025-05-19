package com.ponsun.aml.counterfeit.CounterfeitTeam.services;

import com.ponsun.aml.counterfeit.CounterfeitTeam.domain.CounterfeitTeam;
import com.ponsun.aml.counterfeit.CounterfeitTeam.domain.CounterfeitTeamRepository;
import com.ponsun.aml.counterfeit.CounterfeitTeam.domain.CounterfeitTeamWrapper;
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

public class CounterfeitTeamReadServiceImpl implements CounterfeitTeamReadService {
    private final CounterfeitTeamWrapper counterfeitTeamWrapperTeam;
    private final JdbcTemplate jdbcTemplate;
    private final CounterfeitTeamRepository counterfeitTeamRepository;
    @Override
    public CounterfeitTeam fetchCounterfeitTeamById(Integer id) {
        return this.counterfeitTeamRepository.findById(id).get();
    }
    @Override
        public List<CounterfeitTeam> fetchAllCounterfeitTeam(){
        return this.counterfeitTeamRepository.findAll();
    }

    @Override
    @Transactional
    public Integer getmaxTicketId() {
        Integer ticketId    = 0;
        try {
            String sql = "SELECT COUNT(ticketId)+1 FROM counterfeit_team";
            ticketId = jdbcTemplate.queryForObject(sql,new Object[]{}, Integer.class);
            return ticketId;
        } catch (DataAccessException e) {
            System.err.println("Error getTicketId: " + e.getMessage());
            e.printStackTrace();
        }
        return ticketId;
    }
}