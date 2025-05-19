package com.ponsun.aml.amlTeam.AmlCompleteTeam.data;

import lombok.Data;

@Data
public class ComplaintDto {
    private Integer complaintId;
    private String branchName;
    private String branchCode;
    private String  clientId;
    private String  accountNumber;
    private String  targetCustomerName;

    public ComplaintDto(Integer complaintId, String branchName, String branchCode, String clientId, String accountNumber, String targetCustomerName) {
        this.complaintId = complaintId;
        this.branchName = branchName;
        this.branchCode = branchCode;
        this.clientId = clientId;
        this.accountNumber = accountNumber;
        this.targetCustomerName = targetCustomerName;
    }
    public static ComplaintDto newInstance(Integer complaintId, String branchName, String branchCode, String clientId, String accountNumber, String targetCustomerName){
        return new ComplaintDto(complaintId,branchName,branchCode,clientId,accountNumber,targetCustomerName);
    }
}
