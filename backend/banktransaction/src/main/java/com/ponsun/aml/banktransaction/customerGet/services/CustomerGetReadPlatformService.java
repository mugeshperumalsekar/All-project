package com.ponsun.aml.banktransaction.customerGet.services;

import com.ponsun.aml.banktransaction.customerGet.data.CustomerGetData;

import java.util.List;

public interface CustomerGetReadPlatformService {
    List<CustomerGetData> fetchAllTransactionGetData();

}
