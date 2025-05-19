package com.ponsun.aml.adminconfiguration.AdminUser.services;



import com.ponsun.aml.adminconfiguration.AdminUser.domain.User;

import java.util.List;

public interface UserReadPlatformService {

    User fetchUserById(Integer id);
    List<User> fetchAllUsers();
}
