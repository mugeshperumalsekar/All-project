package com.ponsun.aml.banktransaction.alertGet.services;

import com.ponsun.aml.banktransaction.alertGet.domain.AlertGet;

import java.util.List;

public interface AlertGetReadPlatformService {
    List<AlertGet> fetchAllAlertGet();

    AlertGet fetchAlertGetById(Integer id);
}
