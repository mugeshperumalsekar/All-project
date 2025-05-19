package com.ponsun.aml.banktransaction.alertGet.data;

import lombok.Data;

@Data
public class AlertGetData {
    public Integer id;
    public String alert;
    public String senderAccount;
    public String senderCustomerId;
    public Integer transCount;
    public Double TransCumulativeAmt;
    public String bankAccount;
    public String customerId;
    public Integer transModeId;


    public AlertGetData (final Integer id , final String alert, final String senderAccount , final  String senderCustomerId ,
                         final Integer transCount , final Double TransCumulativeAmt , final String bankAccount , final String customerId , final
                         Integer transModeId){
        this.id = id;
        this.alert = alert;
        this.senderAccount = senderAccount;
        this.senderCustomerId = senderCustomerId;
        this.transCount = transCount;
        this.TransCumulativeAmt = TransCumulativeAmt;
        this.bankAccount = bankAccount;
        this.customerId = customerId;
        this.transModeId = transModeId;
    }

    public static  AlertGetData newInstance (final Integer id , final String alert, final String senderAccount , final  String senderCustomerId ,
                                             final Integer transCount , final Double TransCumulativeAmt , final String bankAccount , final String customerId , final
                                             Integer transModeId) {
        return new AlertGetData(id, alert, senderAccount, senderCustomerId, transCount, TransCumulativeAmt, bankAccount, customerId, transModeId);
    }
}
