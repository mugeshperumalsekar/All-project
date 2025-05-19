package com.ponsun.aml.adminconfiguration.admingroup.services;

import com.ponsun.aml.adminconfiguration.admingroup.domain.Admingroup;

import java.util.List;

public interface AdmingroupReadPlatformService {
    Admingroup fetchAdmingroupById(Integer id);
    List<Admingroup> fetchAllAdmingroup();



}