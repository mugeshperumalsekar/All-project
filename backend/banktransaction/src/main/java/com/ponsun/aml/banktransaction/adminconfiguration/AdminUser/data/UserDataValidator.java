package com.ponsun.aml.banktransaction.adminconfiguration.AdminUser.data;


import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.adminconfiguration.AdminUser.request.CreateUserRequest;
import com.ponsun.aml.banktransaction.adminconfiguration.AdminUser.request.UpdateUserRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class UserDataValidator {

    public void validateSaveModuleDet(final CreateUserRequest request) throws AppicationException {
        if (request.getFullName() == null || request.getFullName().equals("")) {
            throw new AppicationException("ModuleName parameter required");
        }
    }
    public void validateUpdateModuleDet(final UpdateUserRequest request) throws AppicationException {
        if (request.getFullName() == null || request.getFullName().equals("")) {
            throw new AppicationException("ModuleName parameter required");
        }
    }
}
