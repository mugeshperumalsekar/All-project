package com.ponsun.aml.accessPermission.services;

import com.ponsun.aml.accessPermission.data.AccessPermissionData;

import java.util.List;

public interface AccessPermissionWritePlatformService {
    List<AccessPermissionData> fetchAllAccessPermissionData(String uid);
}
