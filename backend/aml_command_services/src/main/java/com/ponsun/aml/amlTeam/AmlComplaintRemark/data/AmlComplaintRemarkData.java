package com.ponsun.aml.amlTeam.AmlComplaintRemark.data;
import lombok.Data;

@Data
public class AmlComplaintRemarkData {
//    private Integer id;
    private Integer uid;
    private String remark;
    private Integer complaintId;
    private Integer branchId;
    private Integer euid;

    public AmlComplaintRemarkData( Integer uid, String remark, Integer complaintId, Integer branchId,Integer euid) {
//        this.id = id;
        this.uid = uid;
        this.remark = remark;
        this.complaintId = complaintId;
        this.branchId = branchId;
        this.euid= euid;
    }
    public static AmlComplaintRemarkData newInstance(Integer uid, String remark, Integer complaintId, Integer branchId,Integer euid){
        return new AmlComplaintRemarkData(uid,remark,complaintId,branchId,euid);
    }
}

