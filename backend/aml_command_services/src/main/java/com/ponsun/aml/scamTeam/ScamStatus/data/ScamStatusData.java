package com.ponsun.aml.scamTeam.ScamStatus.data;

import lombok.Data;

@Data
public class ScamStatusData {
    private Integer id;
    private Integer scamId;
    private String branchCode;
    private Integer branchId;
    private String scamStatus;
    private Integer ticketId;
    private String ticketStatus;
    private Integer uid;
    private Integer euid;
    public ScamStatusData(Integer id,Integer scamId,String branchCode,Integer branchId,String scamStatus,Integer ticketId,String ticketStatus,Integer uid,Integer euid){
        this.id = id;
        this.scamId = scamId;
        this.branchCode = branchCode;
        this.branchId = branchId;
        this.scamStatus = scamStatus;
        this.ticketId = ticketId;
        this.ticketStatus = ticketStatus;
        this.uid = uid;
        this.euid = euid;
    }

    public ScamStatusData newInstance(Integer id, Integer scamId, String branchCode, Integer branchId, String scamStatus, Integer ticketId, String ticketStatus, Integer uid, Integer euid){
        return new ScamStatusData(id,scamId,branchCode,branchId,scamStatus,ticketId,ticketStatus,uid,euid);
    }
}
