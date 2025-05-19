package com.ponsun.aml.amlTeam.AmlComplaintReply.data;

import com.ponsun.aml.amlTeam.AmlComplaintRemark.request.CreateAmlComplaintRemarkRequest;
import com.ponsun.aml.amlTeam.AmlComplaintReply.request.CreateAmlComplaintReplyRequest;
import lombok.Data;

import java.util.List;

@Data
public class ReplayWriteDTO {
    private List<CreateAmlComplaintReplyRequest>createAmlComplaintReplyRequests;
    private CreateAmlComplaintRemarkRequest createAmlComplaintRemarkRequest;

    public ReplayWriteDTO(List<CreateAmlComplaintReplyRequest> createAmlComplaintReplyRequests, CreateAmlComplaintRemarkRequest createAmlComplaintRemarkRequest) {
        this.createAmlComplaintReplyRequests = createAmlComplaintReplyRequests;
        this.createAmlComplaintRemarkRequest = createAmlComplaintRemarkRequest;
    }
    public static ReplayWriteDTO newinstance(List<CreateAmlComplaintReplyRequest> createAmlComplaintReplyRequests, CreateAmlComplaintRemarkRequest createAmlComplaintRemarkRequest){
        return new ReplayWriteDTO(createAmlComplaintReplyRequests,createAmlComplaintRemarkRequest);
    }
}
