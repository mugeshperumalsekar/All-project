package com.ponsun.aml.counterfeit.CounterfeitRemark.request;

import lombok.Data;

@Data
public class AbstractCounterfeitRemarkRequest {
    private Integer id;
    private Integer counterfeitId;
    private Integer branchId;
    private Integer ticketId;
    private String remark;
    private Integer uid;
    private Integer euid;
}
