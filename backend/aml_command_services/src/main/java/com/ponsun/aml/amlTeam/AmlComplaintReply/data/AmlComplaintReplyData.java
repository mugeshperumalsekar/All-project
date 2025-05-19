package com.ponsun.aml.amlTeam.AmlComplaintReply.data;
import lombok.Data;

@Data
public class AmlComplaintReplyData {
    private Integer id;
    private Integer uid;
    private Integer complaintAlertId;
    private String reply;
    private Integer complaintId;
    private Integer euid;


    public AmlComplaintReplyData(Integer id, Integer uid,Integer complaintAlertId, String reply,Integer complaintId,Integer euid) {
        this.id = id;
        this.uid = uid;
        this.complaintAlertId = complaintAlertId;
        this.reply = reply;
        this.complaintId= complaintId;
        this.euid=euid;
    }
    public static AmlComplaintReplyData newinstance(Integer id, Integer uid,Integer complaintAlertId, String reply,Integer complaintId,Integer euid){
        return new AmlComplaintReplyData(id,uid,complaintAlertId,reply,complaintId, euid);
    }
}
