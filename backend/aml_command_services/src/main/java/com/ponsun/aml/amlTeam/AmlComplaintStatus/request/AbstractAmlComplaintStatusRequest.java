package com.ponsun.aml.amlTeam.AmlComplaintStatus.request;

import lombok.Data;

@Data
public class AbstractAmlComplaintStatusRequest {
    private Integer id;
    private Integer uid;
    private Integer ticketId;
    private Integer complaintId;
    private Integer branchId;
    private Integer ticketStatusId;
    private String remark;


}
