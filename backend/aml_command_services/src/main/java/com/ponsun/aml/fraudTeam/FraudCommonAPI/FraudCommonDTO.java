package com.ponsun.aml.fraudTeam.FraudCommonAPI;

import com.ponsun.aml.fraudTeam.FraudObservation.request.CreateFraudObservationRequest;
import com.ponsun.aml.fraudTeam.FraudRemark.request.CreateFraudRemarkRequest;
import com.ponsun.aml.fraudTeam.FraudStatus.request.CreateFraudStatusRequest;
import com.ponsun.aml.fraudTeam.FraudTeam.request.CreateFraudTeamRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
public class FraudCommonDTO {
    private CreateFraudTeamRequest createFraudTeamRequest;
    private List<CreateFraudStatusRequest> createFraudStatusRequest;
    private List<CreateFraudRemarkRequest> createFraudRemarkRequest;
    private List<CreateFraudObservationRequest> createFraudObservationRequest;

    public FraudCommonDTO(CreateFraudTeamRequest createFraudTeamRequest
    , List<CreateFraudStatusRequest> createFraudStatusRequest
    , List<CreateFraudRemarkRequest> createFraudRemarkRequest
    , List<CreateFraudObservationRequest> createFraudObservationRequest){
        this.createFraudTeamRequest = createFraudTeamRequest;
        this.createFraudStatusRequest = createFraudStatusRequest;
        this.createFraudRemarkRequest = createFraudRemarkRequest;
        this.createFraudObservationRequest = createFraudObservationRequest;
    }
    public static FraudCommonDTO newInstance (CreateFraudTeamRequest createFraudTeamRequest
      , List<CreateFraudStatusRequest> createFraudStatusRequest
      , List<CreateFraudRemarkRequest> createFraudRemarkRequest
      , List<CreateFraudObservationRequest> createFraudObservationRequest){
       return new FraudCommonDTO(createFraudTeamRequest,createFraudStatusRequest,createFraudRemarkRequest,createFraudObservationRequest);
    }
}
