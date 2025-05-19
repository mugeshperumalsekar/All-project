package com.ponsun.aml.banktransaction.accountDetails.services;

import com.ponsun.aml.banktransaction.accountDetails.domain.AccountDetails;

import java.util.List;

public interface AccountDetailsReadPlatformService {
    List<AccountDetails> fetchAllAccountDetails();

    AccountDetails fetchAccountDetailsById(Integer id);
}
