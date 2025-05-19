package com.ponsun.aml.amlTeam.AmlComplaintReply.data;

import lombok.Data;

@Data
public class AmlComplaintAlertReplayData {
    private Integer scenarioId;
    private Integer complaintAlertId;
    private String alertScenarios;
    private String replyQry;
    private  String reply;

    public AmlComplaintAlertReplayData(Integer scenarioId, Integer complaintAlertId, String alertScenarios, String replyQry, String reply) {
        this.scenarioId = scenarioId;
        this.complaintAlertId = complaintAlertId;
        this.alertScenarios = alertScenarios;
        this.replyQry = replyQry;
        this.reply = reply;
    }

    public static AmlComplaintAlertReplayData newInstance(Integer scenarioId, Integer complaintAlertId, String alertScenarios, String replyQry, String reply){
        return new AmlComplaintAlertReplayData(scenarioId,complaintAlertId,alertScenarios,replyQry,reply);
    }
}
