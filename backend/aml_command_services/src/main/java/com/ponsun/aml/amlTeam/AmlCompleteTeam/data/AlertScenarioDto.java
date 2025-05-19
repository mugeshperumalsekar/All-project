package com.ponsun.aml.amlTeam.AmlCompleteTeam.data;

import lombok.Data;

@Data
public class AlertScenarioDto {
    private Integer complaintAlertId;
    private String replyQry;
    private String alertScenarios;

    public AlertScenarioDto(Integer complaintAlertId,String replyQry,String alertScenarios) {
        this.complaintAlertId = complaintAlertId;
        this.replyQry=replyQry;
        this.alertScenarios = alertScenarios;

    }
    public static AlertScenarioDto newInstance(Integer complaintAlertId,String replyQry,String alertScenarios){
        return new AlertScenarioDto(complaintAlertId,replyQry,alertScenarios);
    }
}

////    complaintAlertId
////            replyQry