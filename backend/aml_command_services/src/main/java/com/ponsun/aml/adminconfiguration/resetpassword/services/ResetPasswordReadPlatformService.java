package com.ponsun.aml.adminconfiguration.resetpassword.services;



import com.ponsun.aml.adminconfiguration.resetpassword.domain.ResetPassword;

import java.util.List;

public interface ResetPasswordReadPlatformService {
    ResetPassword fetchResetPasswordById(Integer id);
    List<ResetPassword> fetchAllResetPassword();


}
