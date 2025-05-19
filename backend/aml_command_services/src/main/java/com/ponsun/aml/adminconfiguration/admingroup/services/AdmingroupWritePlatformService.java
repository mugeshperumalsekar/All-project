package com.ponsun.aml.adminconfiguration.admingroup.services;


import com.ponsun.aml.adminconfiguration.admingroup.request.CreateAdmingroupRequest;
import com.ponsun.aml.adminconfiguration.admingroup.request.UpdateAdmingroupRequest;
import com.ponsun.aml.infrastructure.utils.Response;

public interface AdmingroupWritePlatformService {

    Response createAdmingroup(CreateAdmingroupRequest createAdmingroupRequest);
    Response updateAdmingroup(Integer id, UpdateAdmingroupRequest updateAdmingroupRequest);
    Response blockAdmingroup(Integer id);
    Response unblockAdmingroup(Integer id);


}
