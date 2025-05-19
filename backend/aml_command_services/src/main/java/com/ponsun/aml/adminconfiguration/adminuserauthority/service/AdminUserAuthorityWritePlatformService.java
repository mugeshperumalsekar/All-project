package com.ponsun.aml.adminconfiguration.adminuserauthority.service;


import com.ponsun.aml.adminconfiguration.adminuserauthority.request.CreateAdminUserAuthorityRequest;
import com.ponsun.aml.adminconfiguration.adminuserauthority.request.UpdateAdminUserAuthorityRequest;
import com.ponsun.aml.infrastructure.utils.Response;

public interface AdminUserAuthorityWritePlatformService {
    Response createAdminUserAuthority(CreateAdminUserAuthorityRequest createAdminUserAuthorityRequest);
    Response updateAdminUserAuthority(Integer id, UpdateAdminUserAuthorityRequest updateAdminUserAuthorityRequest);
    Response blockAdminUserAuthority(Integer id);
    Response unblockAdminUserAuthority(Integer id);
}
