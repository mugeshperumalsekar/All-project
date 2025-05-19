package com.ponsun.aml.banktransaction.accountDetails.request;

import lombok.Data;

import java.util.Date;

@Data
public class AbstractAccountDetailsRequest {
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
}
