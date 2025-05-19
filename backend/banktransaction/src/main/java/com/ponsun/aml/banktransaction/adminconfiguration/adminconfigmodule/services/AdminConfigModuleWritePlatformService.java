package com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmodule.services;


import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmodule.request.CreateAdminConfigModuleRequest;
import com.ponsun.aml.banktransaction.adminconfiguration.adminconfigmodule.request.UpdateAdminConfigModuleRequest;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;

public interface AdminConfigModuleWritePlatformService {
    Response createAdminConfigModule(CreateAdminConfigModuleRequest createAdminConfigModuleRequest) throws AppicationException;
    Response updateAdminConfigModule(Integer id, UpdateAdminConfigModuleRequest updateAdminConfigModuleRequest) throws AppicationException;

    Response deactive(Integer id, Integer euid) throws AppicationException;

    Response blockAdminConfigModule(Integer id) throws AppicationException;
    Response unblockAdminConfigModule(Integer id) throws AppicationException;
}