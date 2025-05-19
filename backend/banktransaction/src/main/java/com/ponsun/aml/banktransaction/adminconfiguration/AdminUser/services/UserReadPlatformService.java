package com.ponsun.aml.banktransaction.adminconfiguration.AdminUser.services;




import com.ponsun.aml.banktransaction.adminconfiguration.AdminUser.domain.User;

import java.util.List;

public interface UserReadPlatformService {

    User fetchUserById(Integer id);
    List<User> fetchAllUsers();
}
