package com.ponsun.aml.banktransaction.alert.services;

import com.ponsun.aml.banktransaction.alert.domain.Alert;

import java.util.List;

public interface AlertReadPlatformService {
    List<Alert> fetchAllAlert();
    Alert fetchAlertById(Integer id);
}
