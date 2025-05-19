package com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.request;

import lombok.Data;

@Data
public class AbstractAmlComplaintAlertScenariosRequest {
    private Integer id;
    private Integer complaintId;
    private Integer scenarioId;
    private String replyQry;
    private Integer euid;
    private Integer uid;

}
