package com.ponsun.aml.fraudTeam.FraudCommonAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ponsun.aml.fraudTeam.FraudObservation.request.CreateFraudObservationRequest;
import com.ponsun.aml.fraudTeam.FraudRemark.request.CreateFraudRemarkRequest;
import com.ponsun.aml.fraudTeam.FraudStatus.request.CreateFraudStatusRequest;
import com.ponsun.aml.fraudTeam.FraudTeam.request.CreateFraudTeamRequest;
import com.ponsun.aml.fraudTeam.FraudTeam.request.UpdateFraudTeamRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;


@RequiredArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FraudWriteDTO {
    private CreateFraudTeamRequest createFraudTeamRequest;
    private UpdateFraudTeamRequest updateFraudTeamRequest;
    private List<CreateFraudStatusRequest> createFraudStatusRequest;
    private List<CreateFraudRemarkRequest> createFraudRemarkRequest;
    private List<CreateFraudObservationRequest> createFraudObservationRequest;

    public FraudWriteDTO
            (CreateFraudTeamRequest createFraudTeamRequest
        , UpdateFraudTeamRequest updateFraudTeamRequest
         , List<CreateFraudStatusRequest> createFraudStatusRequest
         , List<CreateFraudRemarkRequest> createFraudRemarkRequest
        , List<CreateFraudObservationRequest> createFraudObservationRequest){
       this.createFraudTeamRequest = createFraudTeamRequest;
       this.updateFraudTeamRequest = updateFraudTeamRequest;
       this.createFraudStatusRequest = createFraudStatusRequest;
       this.createFraudRemarkRequest = createFraudRemarkRequest;
       this.createFraudObservationRequest = createFraudObservationRequest;
    }
    public static FraudWriteDTO newInstance(
            CreateFraudTeamRequest createFraudTeamRequest
      , UpdateFraudTeamRequest updateFraudTeamRequest
      , List<CreateFraudStatusRequest> createFraudStatusRequest
       , List<CreateFraudRemarkRequest>   createFraudRemarkRequest
         , List<CreateFraudObservationRequest> createFraudObservationRequest){
        return new FraudWriteDTO(createFraudTeamRequest,updateFraudTeamRequest,createFraudStatusRequest,createFraudRemarkRequest,createFraudObservationRequest);
    }
}
