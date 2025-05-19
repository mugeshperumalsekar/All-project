package com.ponsun.aml.counterfeit.CommonAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ponsun.aml.counterfeit.CounterfeitNumber.request.CreateCounterfeitNumberRequest;
import com.ponsun.aml.counterfeit.CounterfeitRemark.request.CreateCounterfeitRemarkRequest;
import com.ponsun.aml.counterfeit.CounterfeitStatus.request.CreateCounterfeitStatusRequest;
import com.ponsun.aml.counterfeit.CounterfeitTeam.request.CreateCounterfeitTeamRequest;
import com.ponsun.aml.counterfeit.CounterfeitTeam.request.UpdateCounterfeitTeamRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CounterfeitWriteDTO {

    private CreateCounterfeitTeamRequest createCounterfeitTeamRequest;
    private UpdateCounterfeitTeamRequest updateCounterfeitTeamRequest;
    private List<CreateCounterfeitStatusRequest> createCounterfeitStatusRequest;
    private List<CreateCounterfeitRemarkRequest> createCounterfeitRemarkRequest;
    private List<CreateCounterfeitNumberRequest> createCounterfeitNumberRequests;
    public CounterfeitWriteDTO
             (CreateCounterfeitTeamRequest createCounterfeitTeamRequest
            ,UpdateCounterfeitTeamRequest updateCounterfeitTeamRequest
            ,List<CreateCounterfeitStatusRequest> createCounterfeitStatusRequest
            ,List<CreateCounterfeitRemarkRequest> createCounterfeitRemarkRequest
            ,List<CreateCounterfeitNumberRequest> createCounterfeitNumberRequests) {

        this.createCounterfeitTeamRequest    = createCounterfeitTeamRequest;
        this.updateCounterfeitTeamRequest    = updateCounterfeitTeamRequest;
        this.createCounterfeitStatusRequest  = createCounterfeitStatusRequest;
        this.createCounterfeitRemarkRequest  = createCounterfeitRemarkRequest;
        this.createCounterfeitNumberRequests = createCounterfeitNumberRequests;
    }
    public static CounterfeitWriteDTO newInstance
             (CreateCounterfeitTeamRequest createCounterfeitTeamRequest
            ,UpdateCounterfeitTeamRequest updateCounterfeitTeamRequest
            ,List<CreateCounterfeitStatusRequest> createCounterfeitStatusRequest
            ,List<CreateCounterfeitRemarkRequest> createCounterfeitRemarkRequest
            ,List<CreateCounterfeitNumberRequest> createCounterfeitNumberRequests) {

        return new CounterfeitWriteDTO(createCounterfeitTeamRequest,updateCounterfeitTeamRequest,createCounterfeitStatusRequest,createCounterfeitRemarkRequest,createCounterfeitNumberRequests);
    }
}
