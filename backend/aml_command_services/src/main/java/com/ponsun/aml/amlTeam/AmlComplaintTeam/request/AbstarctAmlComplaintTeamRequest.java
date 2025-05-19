package com.ponsun.aml.amlTeam.AmlComplaintTeam.request;

import lombok.Data;

@Data
public class AbstarctAmlComplaintTeamRequest {
    private Integer id;
    private Integer ticketId;
    private Integer branchId;
    private String clientId;
    private String accountNumber;
    private String targetCustomerName;
    private Integer uid;
    private Integer euid;
    private Integer ticketStatusId;
}
