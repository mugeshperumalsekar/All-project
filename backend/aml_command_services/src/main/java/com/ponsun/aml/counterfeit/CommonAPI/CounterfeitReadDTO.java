package com.ponsun.aml.counterfeit.CommonAPI;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.ponsun.aml.counterfeit.CounterfeitNumber.data.CounterfeitNumberData;
import com.ponsun.aml.counterfeit.CounterfeitRemark.data.CounterfeitRemarkData;
import com.ponsun.aml.counterfeit.CounterfeitStatus.data.CounterfeitStatusData;
import com.ponsun.aml.counterfeit.CounterfeitTeam.request.CreateCounterfeitTeamRequest;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CounterfeitReadDTO {

    private CreateCounterfeitTeamRequest createCounterfeitTeamRequest;
    private List<CounterfeitStatusData> counterfeitStatusData;
    private List<CounterfeitRemarkData> counterfeitRemarkData;
    private List<CounterfeitNumberData> counterfeitNumberData;
    public CounterfeitReadDTO
            (CreateCounterfeitTeamRequest createCounterfeitTeamRequest
            ,List<CounterfeitStatusData> counterfeitStatusData
            ,List<CounterfeitRemarkData> counterfeitRemarkData
            ,List<CounterfeitNumberData> counterfeitNumberData) {
        this.createCounterfeitTeamRequest = createCounterfeitTeamRequest;
        this.counterfeitStatusData = counterfeitStatusData;
        this.counterfeitRemarkData = counterfeitRemarkData;
        this.counterfeitNumberData = counterfeitNumberData;
    }

    public static CounterfeitReadDTO newInstance
             (CreateCounterfeitTeamRequest createCounterfeitTeamRequest
            ,List<CounterfeitStatusData> counterfeitStatusData
            ,List<CounterfeitRemarkData> counterfeitRemarkData
            ,List<CounterfeitNumberData> counterfeitNumberData) {
        return new CounterfeitReadDTO(createCounterfeitTeamRequest,counterfeitStatusData,counterfeitRemarkData,counterfeitNumberData);
    }
}
