package com.ponsun.aml.fraudTeam.FraudTeam.data;

import lombok.Data;

@Data
public class FraudTeamData {
    private Integer id;
    private String branchCode;
    private Integer branchId;
    private String clientId;
    private String accountNumber;
    private Integer ticketId;
    private String ticketStatus;
    private String targetCustomerName;
    private Integer uid;
    private Integer euid;
    public FraudTeamData(Integer id, String branchCode, Integer branchId, String clientId, String accountNumber, Integer ticketId, String ticketStatus, String targetCustomerName, Integer uid, Integer euid){
        this.id = id;
        this.branchCode = branchCode;
        this.branchId = branchId;
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.ticketId = ticketId;
        this.ticketStatus = ticketStatus;
        this.targetCustomerName = targetCustomerName;
        this.uid = uid;
        this.euid = euid;
    }
    public static FraudTeamData newInstance(Integer id, String branchCode, Integer branchId, String clientId, String accountNumber, Integer ticketId, String ticketStatus, String targetCustomerName, Integer uid, Integer euid){
        return new FraudTeamData(id,branchCode,branchId,clientId,accountNumber,ticketId,ticketStatus,targetCustomerName,uid,euid);
    }
}
