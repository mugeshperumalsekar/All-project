package com.ponsun.aml.adminconfiguration.AdminUser.services;


import com.ponsun.aml.adminconfiguration.AdminUser.request.CreateUserRequest;
import com.ponsun.aml.adminconfiguration.AdminUser.request.UpdateUserRequest;
import com.ponsun.aml.infrastructure.utils.Response;
import org.springframework.transaction.annotation.Transactional;

public interface UserWritePlatformService {

    Response createUser(CreateUserRequest createUserRequest);

    Response updateUser(Integer id, UpdateUserRequest updateUserRequest);

    Response blockUser(Integer id);

    Response unblockUser(Integer id);
}
