package com.ponsun.aml.counterfeit.CounterfeitTeam.request;

import lombok.Data;

@Data
public class AbstractCounterfeitTeamRequest {
    private Integer id;
    private Integer ticketId;
    private String branchCode;
    private String clientId;
    private String accountNumber;
    private String targetCustomerName;
    private Integer uid;
    private Integer euid;
    private String ticketStatus;
    private String branchId;
}
