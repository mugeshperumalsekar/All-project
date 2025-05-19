package com.ponsun.aml.amlTeam.AmlBranchTeam.data;

import lombok.Data;

@Data
public class AmlBranchPendingResponseData {
    private Integer id;
    private String targetCustomerName;
    private String clientId;
    private String accountNumber;
    private Integer ticketId;
    private String branchName;
    private String branchCode;

    public AmlBranchPendingResponseData(Integer id, String targetCustomerName, String clientId, String accountNumber, Integer ticketId, String branchName, String branchCode) {
        this.id = id;
        this.targetCustomerName = targetCustomerName;
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.ticketId = ticketId;
        this.branchName = branchName;
        this.branchCode = branchCode;
    }
    public static AmlBranchPendingResponseData newInsatnce(Integer id, String targetCustomerName, String clientId, String accountNumber, Integer ticketId, String branchName, String branchCode){
        return new AmlBranchPendingResponseData(id,targetCustomerName,clientId,accountNumber,ticketId,branchName,branchCode);
    }
}
