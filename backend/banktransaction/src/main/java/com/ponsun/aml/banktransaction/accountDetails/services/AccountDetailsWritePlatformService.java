package com.ponsun.aml.banktransaction.accountDetails.services;

import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.accountDetails.request.CreateAccountDetailsRequest;
import com.ponsun.aml.banktransaction.accountDetails.request.UpdateAccountDetailsRequest;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;

public interface AccountDetailsWritePlatformService {
    Response createAccountDetails(CreateAccountDetailsRequest createAccountDetailsRequest) throws AppicationException;

    Response updateAccountDetails(Integer id, UpdateAccountDetailsRequest updateAccountDetailsRequest) throws AppicationException;

    Response blockAccountDetails(Integer id) throws AppicationException;

    Response unblockAccountDetails(Integer id) throws AppicationException;

//    Response AlertGeneration();
}
