package com.ponsun.aml.scamTeam.ScamCommonAPI;

import com.ponsun.aml.scamTeam.ScamObservation.request.CreateScamObservationRequest;
import com.ponsun.aml.scamTeam.ScamRemark.request.CreateScamRemarkRequest;
import com.ponsun.aml.scamTeam.ScamStatus.request.CreateScamStatusRequest;
import com.ponsun.aml.scamTeam.ScamTeam.request.CreateScamTeamRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class ScamCommonDTO {
    private CreateScamTeamRequest createScamTeamRequest;
    private List<CreateScamStatusRequest> createScamStatusRequest;
    private List<CreateScamRemarkRequest> createScamRemarkRequest;
    private List<CreateScamObservationRequest> createScamObservationRequest;

    public ScamCommonDTO (CreateScamTeamRequest createScamTeamRequest
    , List<CreateScamStatusRequest> createScamStatusRequest
    , List<CreateScamRemarkRequest> createScamRemarkRequest
    , List<CreateScamObservationRequest> createScamObservationRequest){
        this.createScamTeamRequest = createScamTeamRequest;
        this.createScamStatusRequest = createScamStatusRequest;
        this.createScamRemarkRequest = createScamRemarkRequest;
        this.createScamObservationRequest = createScamObservationRequest;
    }
    public static ScamCommonDTO  newInstance (CreateScamTeamRequest createScamTeamRequest
      , List<CreateScamStatusRequest> createScamStatusRequest
      , List<CreateScamRemarkRequest> createScamRemarkRequest
      , List<CreateScamObservationRequest> createScamObservationRequest){
       return new ScamCommonDTO(createScamTeamRequest,createScamStatusRequest,createScamRemarkRequest,createScamObservationRequest);
    }
}
