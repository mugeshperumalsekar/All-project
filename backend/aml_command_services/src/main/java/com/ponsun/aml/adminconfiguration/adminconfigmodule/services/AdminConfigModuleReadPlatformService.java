package com.ponsun.aml.adminconfiguration.adminconfigmodule.services;



import com.ponsun.aml.adminconfiguration.adminconfigmodule.domain.AdminConfigModule;

import java.util.List;

public interface AdminConfigModuleReadPlatformService {
    AdminConfigModule fetchAdminConfigModuleById(Integer id);
    List<AdminConfigModule> fetchAllAdminConfigModule();
}