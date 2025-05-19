package com.ponsun.aml.amlTeam.AmlComplaintRemark.request;

import lombok.Data;

@Data
public class AbstractAmlComplaintRemarkRequest {
//    private Integer id;
    private Integer uid;
    private String remark;
    private Integer complaintId;
    private Integer branchId;
    private Integer euid;

}
