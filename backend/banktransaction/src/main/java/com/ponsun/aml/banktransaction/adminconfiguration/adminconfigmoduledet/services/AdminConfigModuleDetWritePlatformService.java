package com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmoduledet.services;


import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmoduledet.request.CreateAdminConfigModuleDetRequest;
import com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmoduledet.request.UpdateAdminConfigModuleDetRequest;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;

public interface AdminConfigModuleDetWritePlatformService {
    Response createAdminConfigModuleDet(CreateAdminConfigModuleDetRequest createAdminConfigModuleDetRequest) throws AppicationException;
    Response updateAdminConfigModuleDet(Integer id, UpdateAdminConfigModuleDetRequest updateAdminConfigModuleDetRequest) throws AppicationException;

//    Response deactive(Integer id, Integer euid);
    Response blockAdminConfigModuleDet(Integer id) throws AppicationException;
    Response unblockAdminConfigModuleDet(Integer id) throws AppicationException;
}
