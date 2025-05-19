package com.ponsun.aml.fraudTeam.FraudStatus.data;

import lombok.Data;

@Data
public class FraudStatusData {
    private Integer id;
    private Integer fraudId;
    private String branchCode;
    private Integer branchId;
    private String fraudStatus;
    private Integer ticketId;
    private String ticketStatus;
    private Integer uid;
    private Integer euid;

    public FraudStatusData(Integer id, Integer fraudId, String branchCode, Integer branchId, String fraudStatus, Integer ticketId, String ticketStatus, Integer uid, Integer euid){
        this.id = id;
        this.fraudId = fraudId;
        this.branchCode = branchCode;
        this.branchId = branchId;
        this.fraudStatus = fraudStatus;
        this.ticketId = ticketId;
        this.ticketStatus = ticketStatus;
        this.uid = uid;
        this.euid = euid;
    }
    public static FraudStatusData newInstance(Integer id, Integer fraudId, String branchCode, Integer branchId, String fraudStatus, Integer ticketId, String ticketStatus, Integer uid, Integer euid){
        return new FraudStatusData(id,fraudId,branchCode,branchId,fraudStatus,ticketId,ticketStatus,uid,euid);
    }
}
