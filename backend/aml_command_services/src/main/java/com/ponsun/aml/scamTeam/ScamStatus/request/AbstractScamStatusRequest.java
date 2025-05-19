package com.ponsun.aml.scamTeam.ScamStatus.request;

import lombok.Data;

@Data
public class AbstractScamStatusRequest {
    private Integer id;
    private Integer scamId;
    private String branchCode;
    private Integer branchId;
    private String scamStatus;
    private Integer ticketId;
    private String ticketStatus;
    private Integer uid;
    private Integer euid;
}
