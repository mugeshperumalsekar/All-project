package com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.data;
import lombok.Data;

@Data
public class AmlComplaintAlertScenariosData {
    private Integer id;
    private Integer complaintId;
    private Integer scenarioId;
    private String replyQry;
    private Integer euid;
    private Integer uid;

    public AmlComplaintAlertScenariosData(Integer id, Integer complaintId, Integer scenarioId,String replyQry, Integer euid, Integer uid) {
        this.id = id;
        this.complaintId = complaintId;
        this.scenarioId = scenarioId;
        this.replyQry=replyQry;
        this.euid = euid;
        this.uid = uid;
    }
    public static AmlComplaintAlertScenariosData instance(Integer id, Integer complaintId, Integer scenarioId,String replyQry, Integer euid, Integer uid){
        return new AmlComplaintAlertScenariosData(id,complaintId,scenarioId,replyQry,euid,uid);
    }
}
