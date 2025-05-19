package com.ponsun.aml.banktransaction.configalert.services;

import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.configalert.request.CreateConfigAlertRequest;
import com.ponsun.aml.banktransaction.configalert.request.UpdateConfigAlertRequest;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;

public interface ConfigAlertWritePlatformService {
    Response createAlert(CreateConfigAlertRequest createAlertRequest);

}
