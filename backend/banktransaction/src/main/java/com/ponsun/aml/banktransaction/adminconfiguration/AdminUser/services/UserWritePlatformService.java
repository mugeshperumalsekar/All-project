package com.ponsun.aml.banktransaction.adminconfiguration.AdminUser.services;


import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.adminconfiguration.AdminUser.request.CreateUserRequest;
import com.ponsun.aml.banktransaction.adminconfiguration.AdminUser.request.UpdateUserRequest;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;
import org.springframework.transaction.annotation.Transactional;

public interface UserWritePlatformService {

    Response createUser(CreateUserRequest createUserRequest) throws AppicationException;


    @Transactional
    Response updateUser(Integer id, UpdateUserRequest updateUserRequest) throws AppicationException;



    @Transactional
    Response blockUser(Integer id) throws AppicationException;

    @Transactional
    Response unblockUser(Integer id) throws AppicationException;
}
