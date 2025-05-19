package com.ponsun.aml.banktransaction.bulkImport.domain;

import com.ponsun.aml.banktransaction.bulkImport.request.CreateBulkImportRequest;
import com.ponsun.aml.banktransaction.common.entity.Status;
import com.ponsun.aml.banktransaction.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "bank_transaction_details")
public class BulkImport extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="date")
    private Date date;

    @Column(name = "senderCustomer")
    private String senderCustomer;

    @Column(name = "senderAccount")
    private String senderAccount;

    @Column(name = "sender")
    private String sender;

    @Column(name = "senderBankName")
    private String senderBankName;

    @Column(name = "country")
    private String country;

    @Column(name = "receiverCustomer")
    private String receiverCustomer;

    @Column(name = "receiverAccount")
    private String receiverAccount;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "receiverBankName")
    private String receiverBankName;

    @Column(name = "receiverCountry")
    private String receiverCountry;

    @Column(name = "description")
    private String description;

    @Column(name = "deposits")
    private String deposits;

    @Column(name = "withdrawals")
    private String withdrawals;

    @Column(name = "balance")
    private String balance;


    public static BulkImport create (final CreateBulkImportRequest createBulkImportRequest){
        final BulkImport bulkImport = new BulkImport();

        bulkImport.setDate(createBulkImportRequest.getDate());
        bulkImport.setSenderCustomer(createBulkImportRequest.getSenderCustomer());
        bulkImport.setSenderAccount(createBulkImportRequest.getSenderAccount());
        bulkImport.setSender(createBulkImportRequest.getSender());
        bulkImport.setSenderBankName((createBulkImportRequest.getSenderBankName()));
        bulkImport.setReceiverCustomer(createBulkImportRequest.getReceiverCustomer());
        bulkImport.setReceiverAccount(createBulkImportRequest.getReceiverAccount());
        bulkImport.setReceiver(createBulkImportRequest.getReceiver());
        bulkImport.setReceiverBankName(createBulkImportRequest.getReceiverBankName());
        bulkImport.setDescription(createBulkImportRequest.getDescription());
        bulkImport.setDeposits(createBulkImportRequest.getDeposits());
        bulkImport.setWithdrawals(createBulkImportRequest.getWithdrawals());
        bulkImport.setBalance(createBulkImportRequest.getBalance());
        bulkImport.onCreate();
        bulkImport.setStatus(Status.ACTIVE);
        bulkImport.setCountry(createBulkImportRequest.getCountry());
        bulkImport.setReceiverCountry(createBulkImportRequest.getReceiverCountry());

        return bulkImport;
    }

}
