package com.ponsun.aml.amlTeam.AmlComplaintReply.request;

import lombok.Data;

@Data
public class AbstarctAmlComplaintReplyRequest {
    private Integer id;
    private Integer uid;
    private Integer complaintAlertId;
    private String reply;
    private Integer complaintId;
    private Integer euid;


}
