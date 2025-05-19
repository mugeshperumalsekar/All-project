package com.ponsun.aml.adminconfiguration.adminconfigmoduledet.services;


import com.ponsun.aml.adminconfiguration.adminconfigmoduledet.request.CreateAdminConfigModuleDetRequest;
import com.ponsun.aml.adminconfiguration.adminconfigmoduledet.request.UpdateAdminConfigModuleDetRequest;
import com.ponsun.aml.infrastructure.utils.Response;

public interface AdminConfigModuleDetWritePlatformService {
    Response createAdminConfigModuleDet(CreateAdminConfigModuleDetRequest createAdminConfigModuleDetRequest);
    Response updateAdminConfigModuleDet(Integer id, UpdateAdminConfigModuleDetRequest updateAdminConfigModuleDetRequest);

//    Response deactive(Integer id, Integer euid);
    Response blockAdminConfigModuleDet(Integer id);
    Response unblockAdminConfigModuleDet(Integer id);
}
