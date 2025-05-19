package com.ponsun.aml.banktransaction.transactionGet.data;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class TransactionGetData {
    private String branch;
    private String senderAccount;
    private String withdrawals;
    private LocalDateTime dt;
    private LocalDateTime date;
    private String country;
    private String receiver;
    private String receiverBankName;
    private String receiverCountry;

    public TransactionGetData (String branch ,String senderAccount , String withdrawals , LocalDateTime dt ,LocalDateTime date,String country, String receiver ,String receiverBankName , String receiverCountry ) {
        this.branch = branch;
        this.senderAccount = senderAccount;
        this.withdrawals = withdrawals;
        this.dt = dt;
        this.date = date;
        this.country = country;
        this.receiver = receiver;
        this.receiverBankName = receiverBankName;
        this.receiverCountry = receiverCountry;
    }
    public static TransactionGetData newInstance (String branch , String senderAccount , String withdrawals , LocalDateTime dt ,LocalDateTime date,String country, String receiver ,String receiverBankName , String receiverCountry ) {
        return new TransactionGetData(branch ,senderAccount, withdrawals, dt,date, country, receiver, receiverBankName, receiverCountry);
    }
}
