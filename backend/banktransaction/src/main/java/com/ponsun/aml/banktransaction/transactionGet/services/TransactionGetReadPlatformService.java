package com.ponsun.aml.banktransaction.transactionGet.services;

import com.ponsun.aml.banktransaction.transactionGet.data.TransactionGetData;

import java.util.List;

public interface TransactionGetReadPlatformService {
    List<TransactionGetData> getTransactionDetails(String senderCustomer);
}
