package com.ponsun.aml.counterfeit.CounterfeitRemark.data;

import lombok.Data;

@Data
public class CounterfeitRemarkData {
    private Integer id;
    private Integer counterfeitId;
    private Integer branchId;
    private Integer ticketId;
    private String remark;
    private Integer uid;
    private Integer euid;

    public CounterfeitRemarkData(Integer id, Integer counterfeitId, Integer branchId, Integer ticketId,String remark , Integer uid, Integer euid) {
        this.id = id;
        this.counterfeitId = counterfeitId;
        this.branchId = branchId;
        this.ticketId = ticketId;
        this.remark = remark;
        this.uid = uid;
        this.euid = euid;
    }

    public static CounterfeitRemarkData newInstance (Integer id, Integer counterfeitId, Integer branchId,Integer ticketId, String remark , Integer uid, Integer euid) {
        return new CounterfeitRemarkData(id, counterfeitId,branchId,ticketId,remark,uid,euid);
    }

}
