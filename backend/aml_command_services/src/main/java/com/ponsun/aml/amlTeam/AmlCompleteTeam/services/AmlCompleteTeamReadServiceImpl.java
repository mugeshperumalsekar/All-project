package com.ponsun.aml.amlTeam.AmlCompleteTeam.services;

import com.ponsun.aml.amlTeam.AmlCompleteTeam.data.*;
import com.ponsun.aml.amlTeam.AmlCompleteTeam.rowmapper.AlertScenarioDtoRowmapper;
import com.ponsun.aml.amlTeam.AmlCompleteTeam.rowmapper.ComplaintDtoRowmapper;
import com.ponsun.aml.amlTeam.AmlCompleteTeam.rowmapper.RemarkDtoRowmapper;
import com.ponsun.aml.amlTeam.AmlCompleteTeam.rowmapper.ReplyDtoRowmapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class AmlCompleteTeamReadServiceImpl implements AmlCompleteTeamReadService {
    private final JdbcTemplate jdbcTemplate;
    private final ComplaintDtoRowmapper complaintDtoRowmapper;
    private final AlertScenarioDtoRowmapper alertScenarioDtoRowmapper;
    private final RemarkDtoRowmapper remarkDtoRowmapper;
    private final ReplyDtoRowmapper replyDtoRowmapper;

    @Override
    @Transactional
    public List<ComplaintDto> fetchAllComplaintDto(Integer complaintId) {
        Map<String, Object> parameters = new HashMap<>();

        final ComplaintDtoRowmapper rowMapper = new ComplaintDtoRowmapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE a.branchId=b.id AND a.status='A' AND b.status='A' AND a.id=?";
        Qry = Qry + whereClause;
        final List<ComplaintDto> complaintDtoList=  jdbcTemplate.query(Qry, new Object[]{complaintId}, complaintDtoRowmapper);
        return complaintDtoList;
    }

    @Override
    @Transactional
    public List<AlertScenarioDto> fetchAllAlertScenario(Integer complaintId) {
        Map<String, Object> parameters = new HashMap<>();
        final AlertScenarioDtoRowmapper rowMapper = new AlertScenarioDtoRowmapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE a.scenarioId=b.id AND a.`status`='A' AND a.complaintId=?";
        Qry = Qry + whereClause;
        final List<AlertScenarioDto> alertScenarioDtoList=  jdbcTemplate.query(Qry, new Object[]{complaintId}, alertScenarioDtoRowmapper);
        return alertScenarioDtoList;
    }

    @Override
    @Transactional
    public List<RemarkDto> fetchAllRemark(Integer complaintId) {

        Map<String, Object> parameters = new HashMap<>();
        final RemarkDtoRowmapper rowMapper = new RemarkDtoRowmapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE complaintId=? AND STATUS='A'";
        Qry = Qry + whereClause;
        final List<RemarkDto> remarkDtoList=  jdbcTemplate.query(Qry, new Object[]{complaintId}, remarkDtoRowmapper);
        return remarkDtoList;       }

    @Override
    @Transactional
    public List<ReplyDto> fetchAllReply(Integer complaintId) {

        Map<String, Object> parameters = new HashMap<>();
        final ReplyDtoRowmapper rowMapper = new ReplyDtoRowmapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE complaintId=? AND STATUS='A'";
        Qry = Qry + whereClause;
        final List<ReplyDto> replyDtoList=  jdbcTemplate.query(Qry, new Object[]{complaintId}, replyDtoRowmapper);
        return replyDtoList;
    }

    @Override
    @Transactional
    public CompleteTeamDto fetchAllCommonDto(Integer complaintId) {
        CompleteTeamDto completeTeamDto = new CompleteTeamDto();

        List<ComplaintDto> complaintDto = fetchAllComplaintDto(complaintId);
        List<AlertScenarioDto> alertScenarioDtos = fetchAllAlertScenario(complaintId);
        List<RemarkDto> remarkDtos = fetchAllRemark(complaintId);
        List<ReplyDto> replyDtos=fetchAllReply(complaintId);

        completeTeamDto.setComplaintDto(complaintDto);
        completeTeamDto.setAlertScenarioDtos(alertScenarioDtos);
        completeTeamDto.setRemarkDtos(remarkDtos);
        completeTeamDto.setReplyDtos(replyDtos);

        return completeTeamDto;
    }
}