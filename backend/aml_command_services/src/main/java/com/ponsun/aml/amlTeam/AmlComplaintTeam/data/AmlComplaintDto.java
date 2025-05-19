package com.ponsun.aml.amlTeam.AmlComplaintTeam.data;

import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.data.AmlComplaintAlertScenariosData;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.data.AmlComplaintRemarkData;
import com.ponsun.aml.amlTeam.AmlComplaintReply.data.AmlComplaintReplyData;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.request.CreateAmlComplaintTeamRequest;
import lombok.Data;

import java.util.List;

@Data
public class AmlComplaintDto {
    private CreateAmlComplaintTeamRequest createAmlComplaintTeamRequest;
    private List<AmlComplaintAlertScenariosData> amlComplaintAlertScenariosData;
//    private List<AmlComplaintReplyData> amlComplaintReplyData;
    private List<AmlComplaintRemarkData> amlComplaintRemarkData;

    public AmlComplaintDto(CreateAmlComplaintTeamRequest createAmlComplaintTeamRequest, List<AmlComplaintAlertScenariosData> amlComplaintAlertScenariosData, List<AmlComplaintReplyData> amlComplaintReplyData,List<AmlComplaintRemarkData> amlComplaintRemarkData) {
        this.createAmlComplaintTeamRequest = createAmlComplaintTeamRequest;
        this.amlComplaintAlertScenariosData = amlComplaintAlertScenariosData;
//        this.amlComplaintReplyData = amlComplaintReplyData;
        this.amlComplaintRemarkData = amlComplaintRemarkData;
    }
    public static AmlComplaintDto newInstance(CreateAmlComplaintTeamRequest createAmlComplaintTeamRequest, List<AmlComplaintAlertScenariosData> amlComplaintAlertScenariosData, List<AmlComplaintReplyData> amlComplaintReplyData,List<AmlComplaintRemarkData> amlComplaintRemarkData){
        return new AmlComplaintDto(createAmlComplaintTeamRequest,amlComplaintAlertScenariosData,amlComplaintReplyData,amlComplaintRemarkData);
    }

}
