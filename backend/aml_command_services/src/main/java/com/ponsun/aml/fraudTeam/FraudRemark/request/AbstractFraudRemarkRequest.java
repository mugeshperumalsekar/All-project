package com.ponsun.aml.fraudTeam.FraudRemark.request;

import lombok.Data;

@Data
public class AbstractFraudRemarkRequest {
    private Integer id;
    private Integer fraudId;
    private Integer branchId;
    private Integer ticketId;
    private String remark;
    private Integer uid;
    private Integer euid;
}
