package com.ponsun.aml.amlTeam.AmlComplaintReply.data;

import lombok.Data;

@Data
public class AmlPendingResponseData {
    private Integer id;
    private String targetCustomerName;
    private String clientId;
    private String accountNumber;
    private Integer ticketId;
    private String branchName;
    private String branchCode;
    private String ticketStatus;

    public AmlPendingResponseData(Integer id, String targetCustomerName, String clientId, String accountNumber, Integer ticketId, String branchName, String branchCode, String ticketStatus) {
        this.id = id;
        this.targetCustomerName = targetCustomerName;
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.ticketId = ticketId;
        this.branchName = branchName;
        this.branchCode = branchCode;
        this.ticketStatus = ticketStatus;
    }
    public static AmlPendingResponseData newInstance(Integer id, String targetCustomerName, String clientId, String accountNumber, Integer ticketId, String branchName, String branchCode, String ticketStatus){
        return new AmlPendingResponseData(id,targetCustomerName,clientId,accountNumber,ticketId,branchName,branchCode,ticketStatus);
    }
}
