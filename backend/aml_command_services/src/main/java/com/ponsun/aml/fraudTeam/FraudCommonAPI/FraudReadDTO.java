package com.ponsun.aml.fraudTeam.FraudCommonAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ponsun.aml.fraudTeam.FraudObservation.data.FraudObservationData;
import com.ponsun.aml.fraudTeam.FraudRemark.data.FraudRemarkData;
import com.ponsun.aml.fraudTeam.FraudStatus.data.FraudStatusData;
import com.ponsun.aml.fraudTeam.FraudTeam.request.CreateFraudTeamRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class FraudReadDTO {
    private CreateFraudTeamRequest createFraudTeamRequest;
    private List<FraudStatusData> fraudStatusData;
    private List<FraudRemarkData> fraudRemarkData;
    private List<FraudObservationData> fraudObservationData;

    public FraudReadDTO
            (CreateFraudTeamRequest createFraudTeamRequest
            , List<FraudStatusData> fraudStatusData
            , List<FraudRemarkData> fraudRemarkData
            , List<FraudObservationData> fraudObservationData){
        this.createFraudTeamRequest = createFraudTeamRequest;
        this.fraudStatusData = fraudStatusData;
        this.fraudRemarkData = fraudRemarkData;
        this.fraudObservationData = fraudObservationData;
    }
    public static FraudReadDTO newInstance(
      CreateFraudTeamRequest createFraudTeamRequest
      ,List<FraudStatusData> fraudStatusData
      ,List<FraudRemarkData> fraudRemarkData
      ,List<FraudObservationData> fraudObservationData
    ){
      return new FraudReadDTO(createFraudTeamRequest, fraudStatusData, fraudRemarkData, fraudObservationData);
    }
}
