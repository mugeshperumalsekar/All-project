package com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmoduledet.services;


import com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmoduledet.domain.AdminConfigModuleDet;

import java.util.List;

public interface AdminConfigModuleDetReadPlatformService {

    AdminConfigModuleDet fetchAdminConfigModuleDetById(Integer id);
    List <AdminConfigModuleDet> fetchAllAdminConfigModuleDet();
}
