package com.ponsun.aml.banktransaction.accountDetails.domain;

import com.ponsun.aml.banktransaction.accountDetails.request.CreateAccountDetailsRequest;
import com.ponsun.aml.banktransaction.accountDetails.request.UpdateAccountDetailsRequest;
import com.ponsun.aml.banktransaction.common.entity.Status;
import com.ponsun.aml.banktransaction.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "bank_sender_receiver_details")
public class AccountDetails extends BaseEntity {

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

    @Column(name = "receiverCustomer")
    private String receiverCustomer;

    @Column(name = "receiverAccount")
    private String receiverAccount;

    @Column(name = "receiver")
    private String receiver;

    @Column(name = "receiverBankName")
    private String receiverBankName;

    @Column(name = "description")
    private String description;

    @Column(name = "deposits")
    private String deposits;

    @Column(name = "withdrawals")
    private String withdrawals;

    @Column(name = "balance")
    private String balance;

    public static AccountDetails create(final CreateAccountDetailsRequest createAccountDetailsRequest){
        final AccountDetails accountDetails = new AccountDetails();
        accountDetails.setDate(createAccountDetailsRequest.getDate());
        accountDetails.setSenderCustomer(createAccountDetailsRequest.getSenderCustomer());
        accountDetails.setSenderAccount(createAccountDetailsRequest.getSenderAccount());
        accountDetails.setSender(createAccountDetailsRequest.getSender());
        accountDetails.setSenderBankName((createAccountDetailsRequest.getSenderBankName()));
        accountDetails.setReceiverCustomer(createAccountDetailsRequest.getReceiverCustomer());
        accountDetails.setReceiverAccount(createAccountDetailsRequest.getReceiverAccount());
        accountDetails.setReceiver(createAccountDetailsRequest.getReceiver());
        accountDetails.setReceiverBankName(createAccountDetailsRequest.getReceiverBankName());
        accountDetails.setDescription(createAccountDetailsRequest.getDescription());
        accountDetails.setDeposits(createAccountDetailsRequest.getDeposits());
        accountDetails.setWithdrawals(createAccountDetailsRequest.getWithdrawals());
        accountDetails.setBalance(createAccountDetailsRequest.getBalance());
        accountDetails.onCreate();
        accountDetails.setStatus(Status.ACTIVE);
        return accountDetails;
}

public void update(UpdateAccountDetailsRequest updateAccountDetailsRequest) {

    this.setDate(updateAccountDetailsRequest.getDate());
    this.setSenderCustomer(updateAccountDetailsRequest.getSenderCustomer());
    this.setSenderAccount(updateAccountDetailsRequest.getSenderAccount());
    this.setSender(updateAccountDetailsRequest.getSender());
    this.setSenderBankName((updateAccountDetailsRequest.getSenderBankName()));
    this.setReceiverCustomer(updateAccountDetailsRequest.getReceiverCustomer());
    this.setReceiverAccount(updateAccountDetailsRequest.getReceiverAccount());
    this.setReceiver(updateAccountDetailsRequest.getReceiver());
    this.setReceiverBankName(updateAccountDetailsRequest.getReceiverBankName());
    this.setDescription(updateAccountDetailsRequest.getDescription());
    this.setDeposits(updateAccountDetailsRequest.getDeposits());
    this.setWithdrawals(updateAccountDetailsRequest.getWithdrawals());
    this.setBalance(updateAccountDetailsRequest.getBalance());
    this.onUpdate();
    this.setStatus(Status.ACTIVE);
    }
}
