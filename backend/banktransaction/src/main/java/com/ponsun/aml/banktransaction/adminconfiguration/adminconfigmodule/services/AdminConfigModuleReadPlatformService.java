package com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmodule.services;


import com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmodule.domain.AdminConfigModule;

import java.util.List;

public interface AdminConfigModuleReadPlatformService {
    AdminConfigModule fetchAdminConfigModuleById(Integer id);
    List<AdminConfigModule> fetchAllAdminConfigModule();
}