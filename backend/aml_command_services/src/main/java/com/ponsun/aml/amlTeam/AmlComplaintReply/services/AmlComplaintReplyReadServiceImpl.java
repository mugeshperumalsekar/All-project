package com.ponsun.aml.amlTeam.AmlComplaintReply.services;
import com.ponsun.aml.amlTeam.AmlComplaintReply.data.AmlComplaintAlertReplayData;
import com.ponsun.aml.amlTeam.AmlBranchTeam.data.AmlBranchPendingResponseData;
import com.ponsun.aml.amlTeam.AmlComplaintReply.data.AmlPendingResponseData;
import com.ponsun.aml.amlTeam.AmlComplaintReply.domain.AmlComplaintReply;
import com.ponsun.aml.amlTeam.AmlComplaintReply.domain.AmlComplaintReplyRepository;
import com.ponsun.aml.amlTeam.AmlComplaintReply.domain.AmlComplaintReplyWrapper;
import com.ponsun.aml.amlTeam.AmlComplaintReply.rowmapper.AmlComplaintAlertReplayRowMapper;
import com.ponsun.aml.amlTeam.AmlBranchTeam.rowmapper.AmlBranchPendingResponseRowMapper;
import com.ponsun.aml.amlTeam.AmlComplaintReply.rowmapper.AmlPendingResponseRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AmlComplaintReplyReadServiceImpl implements AmlComplaintReplyReadService {
    private final AmlComplaintReplyWrapper amlComplaintReplyWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final AmlComplaintReplyRepository amlComplaintReplyRepository;
    private final AmlPendingResponseRowMapper amlPendingResponseRowMapper;
    private final AmlComplaintAlertReplayRowMapper amlComplaintAlertReplayRowMapper;


    @Override
    public AmlComplaintReply fetchAmlComplaintReplyById(Integer id) {
        return this.amlComplaintReplyRepository.findById(id).get();
    }

    @Override
    public List<AmlComplaintReply> fetchAllAmlComplaintReply() {
        return this.amlComplaintReplyRepository.findAll();
    }



    @Override
    public List<AmlPendingResponseData> fetchAllAmlPendingResponse() {
        final AmlPendingResponseRowMapper rowMapper = new AmlPendingResponseRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE a.id=b.`complaintId` AND b.id=c.complaintAlertId AND a.`ticketStatusId`=e.id AND a.`branchId`=d.`id` GROUP BY a.id";
        Qry = Qry + whereClause;
        final List<AmlPendingResponseData> pendingResponseData = jdbcTemplate.query(Qry, amlPendingResponseRowMapper);
        return pendingResponseData;

    }

    @Override
    public List<AmlComplaintAlertReplayData> fetchAllAmlAlertReplay(Integer complaintId) {
        final AmlComplaintAlertReplayRowMapper rowMapper = new AmlComplaintAlertReplayRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE a.`scenarioId`=c.id AND a.`id`=b.`complaintAlertId` AND a.`complaintId`=? AND a.`status`='A' AND b.`status`='A'";
        Qry = Qry + whereClause;
        final List<AmlComplaintAlertReplayData> alertReplayData = jdbcTemplate.query(Qry, new Object[]{complaintId}, amlComplaintAlertReplayRowMapper);
        return alertReplayData;
    }
}


