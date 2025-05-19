package com.ponsun.aml.scamTeam.ScamCommonAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ponsun.aml.scamTeam.ScamObservation.data.ScamObservationData;
import com.ponsun.aml.scamTeam.ScamRemark.data.ScamRemarkData;
import com.ponsun.aml.scamTeam.ScamStatus.data.ScamStatusData;
import com.ponsun.aml.scamTeam.ScamTeam.request.CreateScamTeamRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class ScamReadDTO {
    private CreateScamTeamRequest createScamTeamRequest;
    private List<ScamStatusData> scamStatusData;
    private List<ScamRemarkData> scamRemarkData;
    private List<ScamObservationData> scamObservationData;

    public ScamReadDTO
            (CreateScamTeamRequest createScamTeamRequest
            , List<ScamStatusData> scamStatusData
            , List<ScamRemarkData> scamRemarkData
            , List<ScamObservationData> scamObservationData){
        this.createScamTeamRequest = createScamTeamRequest;
        this.scamStatusData = scamStatusData;
        this.scamRemarkData = scamRemarkData;
        this.scamObservationData = scamObservationData;
    }
    public static ScamReadDTO newInstance(
      CreateScamTeamRequest createScamTeamRequest
      ,List<ScamStatusData> scamStatusData
      ,List<ScamRemarkData> scamRemarkData
      ,List<ScamObservationData> scamObservationData
    ){
      return new ScamReadDTO(createScamTeamRequest, scamStatusData, scamRemarkData, scamObservationData);
    }
}
