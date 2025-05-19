package com.ponsun.aml.counterfeit.CommonAPI;

import com.ponsun.aml.counterfeit.CounterfeitNumber.request.CreateCounterfeitNumberRequest;
import com.ponsun.aml.counterfeit.CounterfeitRemark.request.CreateCounterfeitRemarkRequest;
import com.ponsun.aml.counterfeit.CounterfeitStatus.request.CreateCounterfeitStatusRequest;
import com.ponsun.aml.counterfeit.CounterfeitTeam.request.CreateCounterfeitTeamRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class CounterfeitCommonDTO {
    private CreateCounterfeitTeamRequest createCounterfeitTeamRequest;
    private List<CreateCounterfeitStatusRequest> createCounterfeitStatusRequest;
    private List<CreateCounterfeitRemarkRequest> createCounterfeitRemarkRequest;
    private List<CreateCounterfeitNumberRequest> createCounterfeitNumberRequests;
    public CounterfeitCommonDTO (CreateCounterfeitTeamRequest createCounterfeitTeamRequest
            ,List<CreateCounterfeitStatusRequest> createCounterfeitStatusRequest
            ,List<CreateCounterfeitRemarkRequest> createCounterfeitRemarkRequest
            ,List<CreateCounterfeitNumberRequest> createCounterfeitNumberRequests) {
        this.createCounterfeitTeamRequest = createCounterfeitTeamRequest;
        this.createCounterfeitStatusRequest = createCounterfeitStatusRequest;
        this.createCounterfeitRemarkRequest = createCounterfeitRemarkRequest;
        this.createCounterfeitNumberRequests = createCounterfeitNumberRequests;
    }
    public static CounterfeitCommonDTO newInstance (CreateCounterfeitTeamRequest createCounterfeitTeamRequest
            ,List<CreateCounterfeitStatusRequest> createCounterfeitStatusRequest
            ,List<CreateCounterfeitRemarkRequest> createCounterfeitRemarkRequest
            ,List<CreateCounterfeitNumberRequest> createCounterfeitNumberRequests) {
        return new CounterfeitCommonDTO(createCounterfeitTeamRequest,createCounterfeitStatusRequest,createCounterfeitRemarkRequest,createCounterfeitNumberRequests);
    }
}
