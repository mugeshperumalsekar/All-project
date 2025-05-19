package com.ponsun.aml.adminconfiguration.configmodulemoduledet.services;



import com.ponsun.aml.adminconfiguration.configmodulemoduledet.data.ConfigModuleModuleDetData;

import java.util.List;

public interface ConfigModuleModuleDetWritePlatformService {
    List<ConfigModuleModuleDetData> fetchAllListofAlertData();
}
