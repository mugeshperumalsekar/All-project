package com.ponsun.aml.adminconfiguration.resetpassword.services;


import com.ponsun.aml.adminconfiguration.resetpassword.request.CreateResetPasswordRequest;
import com.ponsun.aml.adminconfiguration.resetpassword.request.UpdateResetPasswordRequest;
import com.ponsun.aml.infrastructure.utils.Response;

public interface ResetPasswordWritePlatformService {
     Response createResetPassword(CreateResetPasswordRequest createResetPasswordRequest);
     Response updateResetPassword(Integer id, UpdateResetPasswordRequest updateResetPasswordRequest);
    Response blockResetPassword(Integer id);
    Response unblockResetPassword(Integer id);
}
