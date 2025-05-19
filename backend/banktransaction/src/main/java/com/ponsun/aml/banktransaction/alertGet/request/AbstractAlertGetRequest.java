package com.ponsun.aml.banktransaction.alertGet.request;

import lombok.Data;

@Data
public class AbstractAlertGetRequest {

    public Integer id;
    public String alert;
    public String senderAccount;
    public String senderCustomerId;
    public Integer transCount;
    public Double TransCumulativeAmt;
    public String bankAccount;
    public Integer customerId;
    public Integer transModeId;
}
