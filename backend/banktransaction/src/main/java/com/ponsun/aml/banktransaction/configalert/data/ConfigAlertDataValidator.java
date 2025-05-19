package com.ponsun.aml.banktransaction.configalert.data;

import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.configalert.request.CreateConfigAlertRequest;
import com.ponsun.aml.banktransaction.configalert.request.UpdateConfigAlertRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ConfigAlertDataValidator {

    public void validateSaveAlertData(final CreateConfigAlertRequest request) throws AppicationException {
        if(request.getDays() == null || request.getDays().equals("")){
            throw new AppicationException("BankAccount parameter required");
        }
    }
    public void validateUpdateAlertData(final UpdateConfigAlertRequest request) throws AppicationException {
        if(request.getDays() == null || request.getDays().equals("")){
            throw new AppicationException("BankAccount parameter required");
        }
    }
    
}
