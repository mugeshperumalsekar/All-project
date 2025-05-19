package com.ponsun.aml.scamTeam.ScamRemark.request;

import lombok.Data;

@Data
public class AbstractScamRemarkRequest {
    private Integer id;
    private Integer scamId;
    private Integer branchId;
    private Integer ticketId;
    private String remark;
    private Integer uid;
    private Integer euid;
}
