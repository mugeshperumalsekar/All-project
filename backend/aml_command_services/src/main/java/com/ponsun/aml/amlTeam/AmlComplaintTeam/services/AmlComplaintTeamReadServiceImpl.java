package com.ponsun.aml.amlTeam.AmlComplaintTeam.services;

import com.ponsun.aml.amlTeam.AmlComplaintTeam.domain.AmlComplaintTeam;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.domain.AmlComplaintTeamRepository;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.domain.AmlComplaintTeamWrapper;
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
public class AmlComplaintTeamReadServiceImpl implements AmlComplaintTeamReadService {
    private final AmlComplaintTeamWrapper amlConfigBranchWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final AmlComplaintTeamRepository amlComplaintTeamRepository;

    @Override
    @Transactional
    public AmlComplaintTeam fetchAmlBranchById(Integer id){
        return this.amlComplaintTeamRepository.findById(id).get();
    }
    @Override
    public List<AmlComplaintTeam> fetchAllAmlBranch(){
        return this.amlComplaintTeamRepository.findAll();
    }


    @Override
    @Transactional
    public Integer getmaxTicketId() {
        Integer ticketId    = 0;
        try {
            String sql = "SELECT COUNT(ticketId)+1 FROM aml_complaint_team";
            ticketId = jdbcTemplate.queryForObject(sql,new Object[]{}, Integer.class);
            return ticketId;
        } catch (DataAccessException e) {
            System.err.println("Error getTicketId: " + e.getMessage());
            e.printStackTrace();
        }
        return ticketId;
    }

}