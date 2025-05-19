package com.ponsun.aml.banktransaction.accountDetails.data;

import lombok.Data;

import java.util.Date;

@Data

public class AccountDetailsData {
    private Integer id;
    private Date date;
    private String senderCustomer;
    private String senderAccount;
    private String sender;
    private String senderBankName;
    private String receiverCustomer;
    private String receiverAccount;
    private String receiver;
    private String receiverBankName;
    private String description;
    private String deposits;
    private String withdrawals;
    private String balance;

    public AccountDetailsData (final Integer id,
            final Date date ,
            final String senderCustomer ,final String senderAccount, final String sender,final String senderBankName,
            final String receiverCustomer , final String receiverAccount ,final  String receiver ,final String receiverBankName ,
            final String description , final String deposits , final String withdrawals , final String balance) {
        this.id = id;
        this.date = date;
        this.senderCustomer = senderCustomer;
        this.senderAccount = senderAccount;
        this.sender =sender;
        this.senderBankName = senderBankName;
        this.receiverCustomer = receiverCustomer;
        this.receiverAccount = receiverAccount;
        this.receiver = receiver;
        this.receiverBankName = receiverBankName;
        this.description = description;
        this.deposits = deposits;
        this.withdrawals = withdrawals;
        this.balance = balance;
    }
    public static AccountDetailsData newInstance (final Integer id,
            final Date date ,
            final String senderCustomer ,final String senderAccount, final String sender,final String senderBankName,
            final String receiverCustomer , final String receiverAccount ,final  String receiver ,final String receiverBankName ,
            final String description , final String deposits , final String withdrawals , final String balance) {

        return new AccountDetailsData(id,date,senderCustomer,senderAccount,sender,senderBankName,receiverCustomer,receiverAccount,receiver,receiverBankName,description,deposits,withdrawals,balance);
    }

}
