package com.ponsun.aml.adminconfiguration.resetpassword.data;


import com.ponsun.aml.adminconfiguration.resetpassword.request.CreateResetPasswordRequest;
import com.ponsun.aml.adminconfiguration.resetpassword.request.UpdateResetPasswordRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ResetPasswordDataValidator {
    public void validateSaveResetPassword(final CreateResetPasswordRequest request) {
        if (request.getPassword() == null || request.getPassword().equals("")) {
            throw new EQAS_AML_AppicationException("Password parameter required");
        }
    }
    public void validateUpdateResetPassword(final UpdateResetPasswordRequest request) {
        if (request.getPassword() == null || request.getPassword().equals("")) {
            throw new EQAS_AML_AppicationException("ModuleName parameter required");
        }
    }
}
