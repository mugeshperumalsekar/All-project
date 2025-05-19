package com.ponsun.aml.counterfeit.CounterfeitTeam.data;

import lombok.Data;

@Data
public class CounterfeitTeamData {
    private Integer id;
    private Integer ticketId;
    private String branchCode;
    private String clientId;
    private String accountNumber;
    private String targetCustomerName;
    private Integer uid;
    private Integer euid;
    private String ticketStatus;
    private Integer branchId;


    public CounterfeitTeamData(Integer id, Integer ticketId, String branchCode, String clientId, String accountNumber, String targetCustomerName, Integer uid, Integer euid, String ticketStatus,Integer branchId) {
        this.id = id;
        this.ticketId = ticketId;
        this.branchCode = branchCode;
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.targetCustomerName = targetCustomerName;
        this.uid = uid;
        this.euid = euid;
        this.ticketStatus = ticketStatus;
        this.branchId = branchId;
    }
    public static CounterfeitTeamData newInstance(Integer id, Integer ticketId,String branchCode, String clientId, String accountNumber, String targetCustomerName, Integer uid, Integer euid, String ticketStatus,Integer branchId){
        return new CounterfeitTeamData(id, ticketId,branchCode,clientId,accountNumber,targetCustomerName,uid,euid, ticketStatus,branchId);
    }
}
