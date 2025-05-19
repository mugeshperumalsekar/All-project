package com.ponsun.aml.fraudTeam.FraudTeam.request;

import lombok.Data;

@Data
public class AbstractFraudTeamRequest {
    private Integer id;
    private String branchCode;
    private Integer branchId;
    private String clientId;
    private String accountNumber;
    private Integer ticketId;
    private String ticketStatus;
    private String targetCustomerName;
    private Integer uid;
    private Integer euid;
}
