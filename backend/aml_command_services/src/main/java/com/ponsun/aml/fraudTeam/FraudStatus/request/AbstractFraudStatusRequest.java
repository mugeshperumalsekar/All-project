package com.ponsun.aml.fraudTeam.FraudStatus.request;

import lombok.Data;

@Data
public class AbstractFraudStatusRequest {
    private Integer id;
    private Integer fraudId;
    private String branchCode;
    private Integer branchId;
    private String fraudStatus;
    private Integer ticketId;
    private String ticketStatus;
    private Integer uid;
    private Integer euid;
}
