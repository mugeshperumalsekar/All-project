package com.ponsun.aml.amlTeam.AmlComplaintStatus.data;

import lombok.Data;

@Data
public class AmlComplaintStatusData {
    private Integer id;
    private Integer uid;
    private Integer ticketId;
    private Integer complaintId;
    private Integer branchId;
    private Integer ticketStatusId;
    private String remark;


    public AmlComplaintStatusData(Integer id, Integer uid, Integer ticketId,Integer complaintId, Integer branchId, Integer ticketStatusId,String remark) {
        this.id = id;
        this.uid = uid;
        this.ticketId = ticketId;
        this.complaintId= complaintId;
        this.branchId = branchId;
        this.ticketStatusId = ticketStatusId;
        this.remark = remark;
    }

    public static AmlComplaintStatusData newInstance(Integer id, Integer uid, Integer ticketId,Integer complaintId, Integer branchId, Integer ticketStatusId,String remark){
        return new AmlComplaintStatusData(id,uid,ticketId,complaintId,branchId,ticketStatusId,remark);
    }
}
