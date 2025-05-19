package com.ponsun.aml.amlTeam.AmlBranchTeam.services;

import com.ponsun.aml.amlTeam.AmlBranchTeam.data.AmlBranchPendingResponseData;
import com.ponsun.aml.amlTeam.AmlBranchTeam.rowmapper.AmlBranchPendingResponseRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AmlBranchTeamReadServiceImpl implements AmlBranchTeamReadService{
    private final JdbcTemplate jdbcTemplate;
    private final AmlBranchPendingResponseRowMapper amlBranchPendingResponseRowMapper;

    @Override
    public List<AmlBranchPendingResponseData> fetchAllAmlBranchPendingResponse(Integer branchId ) {
        final AmlBranchPendingResponseRowMapper rowMapper = new AmlBranchPendingResponseRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE  a.`ticketStatusId`=1 AND a.branchId=? AND a.`branchId`=d.`id` GROUP BY a.id";
        Qry = Qry + whereClause;
        final List<AmlBranchPendingResponseData> branchPendingResponseData = jdbcTemplate.query(Qry,new Object[]{branchId}, amlBranchPendingResponseRowMapper);
        return branchPendingResponseData;
    }
}
