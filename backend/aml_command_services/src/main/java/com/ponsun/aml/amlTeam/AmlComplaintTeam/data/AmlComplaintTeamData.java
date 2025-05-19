package com.ponsun.aml.amlTeam.AmlComplaintTeam.data;

import lombok.Data;

@Data
public class AmlComplaintTeamData {
    private Integer id;
    private Integer ticketId;
    private Integer branchId;
    private String clientId;
    private String accountNumber;
    private String targetCustomerName;
    private Integer uid;
    private Integer euid;
    private Integer ticketStatusId;


    public AmlComplaintTeamData(Integer id, Integer ticketId, Integer branchId, String clientId, String accountNumber, String targetCustomerName, Integer uid, Integer euid, Integer ticketStatusId) {
        this.id = id;
        this.ticketId = ticketId;
        this.branchId = branchId;
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.targetCustomerName = targetCustomerName;
        this.uid = uid;
        this.euid = euid;
        this.ticketStatusId = ticketStatusId;

    }
    public static AmlComplaintTeamData newInstance(Integer id, Integer ticketId, Integer branchId, String clientId, String accountNumber, String targetCustomerName, Integer uid, Integer euid, Integer ticketStatusId){
        return new AmlComplaintTeamData(id,ticketId,branchId,clientId,accountNumber,targetCustomerName,uid,euid,ticketStatusId);
    }
}
