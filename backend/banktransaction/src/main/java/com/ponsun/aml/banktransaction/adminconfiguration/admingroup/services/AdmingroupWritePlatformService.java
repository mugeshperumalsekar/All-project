package com.ponsun.aml.banktransaction.adminconfiguration.admingroup.services;


import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.adminconfiguration.admingroup.request.CreateAdmingroupRequest;
import com.ponsun.aml.banktransaction.adminconfiguration.admingroup.request.UpdateAdmingroupRequest;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;

public interface AdmingroupWritePlatformService {

    Response createAdmingroup(CreateAdmingroupRequest createAdmingroupRequest) throws AppicationException;
    Response updateAdmingroup(Integer id, UpdateAdmingroupRequest updateAdmingroupRequest) throws AppicationException;
    Response blockAdmingroup(Integer id) throws AppicationException;
    Response unblockAdmingroup(Integer id) throws AppicationException;


}
