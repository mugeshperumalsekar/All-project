package com.ponsun.aml.banktransaction.alert.data;

import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.alert.request.CreateAlertRequest;
import com.ponsun.aml.banktransaction.alert.request.UpdateAlertRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class AlertDataValidator {

    public void validateSaveAlertData(final CreateAlertRequest request) throws AppicationException {
        if(request.getBankAccount() == null || request.getBankAccount().equals("")){
            throw new AppicationException("BankAccount parameter required");
        }
    }
    public void validateUpdateAlertData(final UpdateAlertRequest request) throws AppicationException {
        if(request.getBankAccount() == null || request.getBankAccount().equals("")){
            throw new AppicationException("BankAccount parameter required");
        }
    }
    
}
