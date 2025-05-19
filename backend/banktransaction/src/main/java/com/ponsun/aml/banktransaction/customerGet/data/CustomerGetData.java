package com.ponsun.aml.banktransaction.customerGet.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
@Data
@RequiredArgsConstructor
public class CustomerGetData {
private Integer id;
    private Integer transModeId;
    private Integer transCount;
    private Double transCumulativeAmt;
    private String customerId;
    private String accountId;
    private String alertDetails;
    private LocalDateTime dt;
    private Integer assignInvestigation;
    private String txnAlert;
    private String description;
    private String customerName;
    private String accountNum;
    private String bankName;
    private String branchName;
    private Integer pocId;
    private Integer isCumulativeEntry;

    public CustomerGetData(Integer id,Integer transModeId, Integer transCount, Double transCumulativeAmt,
                           String customerId, String accountId, String alertDetails, LocalDateTime dt,
                           Integer assignInvestigation, String txnAlert, String description,
                           String customerName, String accountNum, String bankName, String branchName,Integer pocId , Integer isCumulativeEntry) {
        this.id = id;
        this.transModeId = transModeId;
        this.transCount = transCount;
        this.transCumulativeAmt = transCumulativeAmt;
        this.customerId = customerId;
        this.accountId = accountId;
        this.alertDetails = alertDetails;
        this.dt = dt;
        this.assignInvestigation = assignInvestigation;
        this.txnAlert = txnAlert;
        this.description = description;
        this.customerName = customerName;
        this.accountNum = accountNum;
        this.bankName = bankName;
        this.branchName = branchName;
        this.pocId = pocId;
        this.isCumulativeEntry = isCumulativeEntry;
    }
}
