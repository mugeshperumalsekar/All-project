package com.ponsun.aml.banktransaction.bulkImport.request;


import lombok.Data;

import java.util.Date;

@Data
public abstract class AbstractBulkImportBaseRequest {
    private Integer id;
    private Date date;
    private String senderCustomer;
    private String senderAccount;
    private String sender;
    private String senderBankName;
    private String country;
    private String receiverCountry;
    private String receiverCustomer;
    private String receiverAccount;
    private String receiver;
    private String receiverBankName;
    private String description;
    private String deposits;
    private String withdrawals;
    private String balance;
}
