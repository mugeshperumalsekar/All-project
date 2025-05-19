package com.ponsun.aml.banktransaction.adminconfiguration.admingroup.services;



import com.ponsun.aml.banktransaction.adminconfiguration.admingroup.domain.Admingroup;

import java.util.List;

public interface AdmingroupReadPlatformService {
    Admingroup fetchAdmingroupById(Integer id);
    List<Admingroup> fetchAllAdmingroup();
}