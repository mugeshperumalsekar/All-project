package com.ponsun.aml.banktransaction.accountDetails.data;

import com.ponsun.aml.banktransaction.accountDetails.request.CreateAccountDetailsRequest;
import com.ponsun.aml.banktransaction.accountDetails.request.UpdateAccountDetailsRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AccountDetailsDataValidator {

    public void validateSaveAccountDetailsData(final CreateAccountDetailsRequest request) throws AppicationException {
        if(request.getSender() == null || request.getSender().equals("")){
           throw new AppicationException("Sender parameter required");
        }
    }
    public void validateUpdateAccountDetailsData(final UpdateAccountDetailsRequest request) throws AppicationException {
        if(request.getSender() == null || request.getBalance().equals("")){
            throw new AppicationException("Sender parameter required");
        }
    }
}
