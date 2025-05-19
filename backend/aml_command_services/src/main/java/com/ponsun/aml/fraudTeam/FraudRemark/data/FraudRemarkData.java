package com.ponsun.aml.fraudTeam.FraudRemark.data;

import lombok.Data;

@Data
public class FraudRemarkData {
    private Integer id;
    private Integer fraudId;
    private Integer branchId;
    private Integer ticketId;
    private String remark;
    private Integer uid;
    private Integer euid;
    public FraudRemarkData(Integer id, Integer fraudId, Integer branchId, Integer ticketId, String remark, Integer uid, Integer euid){
        this.id = id;
        this.fraudId = fraudId;
        this.branchId = branchId;
        this.ticketId = ticketId;
        this.remark = remark;
        this.uid = uid;
        this.euid = euid;
    }
    public static FraudRemarkData newInstance(Integer id, Integer fraudId, Integer branchId, Integer ticketId, String remark, Integer uid, Integer euid){
        return new FraudRemarkData(id,fraudId,branchId,ticketId,remark,uid,euid);
    }
}
