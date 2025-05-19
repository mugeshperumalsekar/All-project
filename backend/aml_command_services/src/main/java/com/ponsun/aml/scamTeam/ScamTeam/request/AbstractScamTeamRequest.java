package com.ponsun.aml.scamTeam.ScamTeam.request;

import lombok.Data;

@Data
public class AbstractScamTeamRequest {
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
