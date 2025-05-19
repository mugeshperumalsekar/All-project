package com.ponsun.aml.banktransaction.alert.services;

import com.ponsun.aml.banktransaction.accountDetails.data.AppicationException;
import com.ponsun.aml.banktransaction.alert.request.CreateAlertRequest;
import com.ponsun.aml.banktransaction.alert.request.UpdateAlertRequest;
import com.ponsun.aml.banktransaction.infrastructure.utils.Response;

public interface AlertWritePlatformService {
    Response createAlert(CreateAlertRequest createAlertRequest) throws AppicationException;

    Response updateAlert(Integer id, UpdateAlertRequest updateAlertRequest) throws AppicationException;

    Response blockAlert(Integer id) throws AppicationException;

    Response unblockAlert(Integer id) throws AppicationException;
}
