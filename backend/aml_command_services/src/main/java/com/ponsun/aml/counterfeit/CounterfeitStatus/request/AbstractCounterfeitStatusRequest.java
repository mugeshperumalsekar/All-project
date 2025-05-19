package com.ponsun.aml.counterfeit.CounterfeitStatus.request;

import lombok.Data;

@Data
public class AbstractCounterfeitStatusRequest {
    private Integer id;
    private Integer counterfeitId;
    private String branchCode;
    private Integer branchId;
    private String counterfeitStatus;
    private String ticketStatus;
    private Integer ticketId;
    private Integer uid;
    private Integer euid;
}
