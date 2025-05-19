package com.ponsun.aml.scamTeam.ScamCommonAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ponsun.aml.scamTeam.ScamObservation.request.CreateScamObservationRequest;
import com.ponsun.aml.scamTeam.ScamRemark.request.CreateScamRemarkRequest;
import com.ponsun.aml.scamTeam.ScamStatus.request.CreateScamStatusRequest;
import com.ponsun.aml.scamTeam.ScamTeam.request.CreateScamTeamRequest;
import com.ponsun.aml.scamTeam.ScamTeam.request.UpdateScamTeamRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScamWriteDTO {
    private CreateScamTeamRequest createScamTeamRequest;
    private UpdateScamTeamRequest updateScamTeamRequest;
    private List<CreateScamStatusRequest> createScamStatusRequest;
    private List<CreateScamRemarkRequest> createScamRemarkRequest;
    private List<CreateScamObservationRequest> createScamObservationRequest;

    public ScamWriteDTO
            (CreateScamTeamRequest createScamTeamRequest
        , UpdateScamTeamRequest updateScamTeamRequest
         , List<CreateScamStatusRequest> createScamStatusRequest
         , List<CreateScamRemarkRequest> createScamRemarkRequest
        , List<CreateScamObservationRequest> createScamObservationRequest){
       this.createScamTeamRequest = createScamTeamRequest;
       this.updateScamTeamRequest = updateScamTeamRequest;
       this.createScamStatusRequest = createScamStatusRequest;
       this.createScamRemarkRequest = createScamRemarkRequest;
       this.createScamObservationRequest = createScamObservationRequest;
    }
    public static ScamWriteDTO newInstance(
            CreateScamTeamRequest createScamTeamRequest
      , UpdateScamTeamRequest updateScamTeamRequest
      , List<CreateScamStatusRequest> createScamStatusRequest
       , List<CreateScamRemarkRequest>   createScamRemarkRequest
         , List<CreateScamObservationRequest> createScamObservationRequest){
        return new ScamWriteDTO(createScamTeamRequest,updateScamTeamRequest,createScamStatusRequest,createScamRemarkRequest,createScamObservationRequest);
    }
}
