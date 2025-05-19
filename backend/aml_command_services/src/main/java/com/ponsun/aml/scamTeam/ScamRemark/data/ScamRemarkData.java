package com.ponsun.aml.scamTeam.ScamRemark.data;

import lombok.Data;

@Data
public class ScamRemarkData {
    private Integer id;
    private Integer scamId;
    private Integer branchId;
    private Integer ticketId;
    private String remark;
    private Integer uid;
    private Integer euid;
    public ScamRemarkData(Integer id,Integer scamId,Integer branchId,Integer ticketId,String remark,Integer uid,Integer euid){
        this.id = id;
        this.scamId = scamId;
        this.branchId = branchId;
        this.ticketId = ticketId;
        this.remark = remark;
        this.uid = uid;
        this.euid = euid;
    }

    public static ScamRemarkData newInstance(Integer id, Integer scamId, Integer branchId, Integer ticketId, String remark, Integer uid, Integer euid){
        return new ScamRemarkData(id,scamId,branchId,ticketId,remark,uid,euid);
    }
}
