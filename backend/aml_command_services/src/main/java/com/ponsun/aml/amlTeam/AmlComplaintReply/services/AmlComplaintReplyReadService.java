package com.ponsun.aml.amlTeam.AmlComplaintReply.services;

import com.ponsun.aml.amlTeam.AmlComplaintReply.data.AmlComplaintAlertReplayData;
import com.ponsun.aml.amlTeam.AmlBranchTeam.data.AmlBranchPendingResponseData;
import com.ponsun.aml.amlTeam.AmlComplaintReply.data.AmlPendingResponseData;
import com.ponsun.aml.amlTeam.AmlComplaintReply.domain.AmlComplaintReply;

import java.util.List;

public interface AmlComplaintReplyReadService {
    AmlComplaintReply fetchAmlComplaintReplyById(Integer id);
    List<AmlComplaintReply> fetchAllAmlComplaintReply();
    List<AmlPendingResponseData> fetchAllAmlPendingResponse();
    List<AmlComplaintAlertReplayData> fetchAllAmlAlertReplay(Integer complaintId);



}
