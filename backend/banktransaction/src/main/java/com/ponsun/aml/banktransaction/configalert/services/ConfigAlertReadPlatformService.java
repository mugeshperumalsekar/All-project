package com.ponsun.aml.banktransaction.configalert.services;

import com.ponsun.aml.banktransaction.configalert.domain.ConfigAlert;

import java.util.List;

public interface ConfigAlertReadPlatformService {
    List<ConfigAlert> fetchAllAlert();
    ConfigAlert fetchAlertById(Integer id);
}
