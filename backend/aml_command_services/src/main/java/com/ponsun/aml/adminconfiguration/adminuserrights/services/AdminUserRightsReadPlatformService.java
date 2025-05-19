package com.ponsun.aml.adminconfiguration.adminuserrights.services;

import com.ponsun.aml.adminconfiguration.adminuserrights.domain.AdminUserRights;

import java.util.List;

public interface AdminUserRightsReadPlatformService {

    AdminUserRights fetchAdminUserRightsById (Integer id);
    List<AdminUserRights> fetchAllAdminUserRights();
}
