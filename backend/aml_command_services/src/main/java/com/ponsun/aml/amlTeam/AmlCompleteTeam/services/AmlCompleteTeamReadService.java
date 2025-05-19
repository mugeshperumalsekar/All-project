package com.ponsun.aml.amlTeam.AmlCompleteTeam.services;

import com.ponsun.aml.amlTeam.AmlCompleteTeam.data.*;

import java.util.List;

public interface AmlCompleteTeamReadService {
    List<ComplaintDto> fetchAllComplaintDto(Integer complaintId);
    List<AlertScenarioDto> fetchAllAlertScenario(Integer complaintId);
    List<RemarkDto> fetchAllRemark(Integer complaintId);
    List<ReplyDto> fetchAllReply(Integer complaintId);
    CompleteTeamDto fetchAllCommonDto(Integer complaintId);

}