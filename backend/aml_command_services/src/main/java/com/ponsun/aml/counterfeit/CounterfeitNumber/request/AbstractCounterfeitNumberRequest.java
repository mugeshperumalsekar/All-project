package com.ponsun.aml.counterfeit.CounterfeitNumber.request;

import lombok.Data;

@Data
public class AbstractCounterfeitNumberRequest {
    private Integer id;
    private Integer counterfeitId;
    private String counterfeitNo;
    private String denomination;
    private Integer ticketId;
    private Integer branchId;
    private String ticketStatus;
    private Integer uid;
    private Integer euid;
}
