package com.ponsun.aml.adminconfiguration.adminuserauthority.service;



import com.ponsun.aml.adminconfiguration.adminuserauthority.domain.AdminUserAuthority;

import java.util.List;

public interface AdminUserAuthorityReadPlatformService {
    AdminUserAuthority fetchAdminUserAuthorityById (Integer id);
    List<AdminUserAuthority> fetchAllAdminUserAuthority();
}
