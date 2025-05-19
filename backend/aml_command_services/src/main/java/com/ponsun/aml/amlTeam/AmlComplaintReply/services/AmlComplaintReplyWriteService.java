package com.ponsun.aml.amlTeam.AmlComplaintReply.services;

import com.ponsun.aml.amlTeam.AmlComplaintRemark.request.CreateAmlComplaintRemarkRequest;
import com.ponsun.aml.amlTeam.AmlComplaintReply.data.ReplayWriteDTO;
import com.ponsun.aml.amlTeam.AmlComplaintReply.request.CreateAmlComplaintReplyRequest;
import com.ponsun.aml.amlTeam.AmlComplaintReply.request.UpdateAmlComplaintReplyrequest;
import com.ponsun.aml.amlTeam.AmlCompleteTeam.data.ComplaintDto;
import com.ponsun.aml.infrastructure.utils.Response;

import java.util.List;

public interface AmlComplaintReplyWriteService {
    Response createAmlComplaintReplyList(List<CreateAmlComplaintReplyRequest> createAmlComplaintReplyRequest);
    Response updateAmlComplaintReplyList(Integer id, UpdateAmlComplaintReplyrequest updateAmlComplaintReplyrequest);
    Response createReplaySave(ReplayWriteDTO replayWriteDTO);
    Response updateReplaySave(Integer complaintId,Integer euid, ReplayWriteDTO replayWriteDTO);

}
