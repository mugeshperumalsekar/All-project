package com.ponsun.aml.counterfeit.CounterfeitStatus.services;

import com.ponsun.aml.counterfeit.CounterfeitStatus.data.CounterfeitStatusData;
import com.ponsun.aml.infrastructure.utils.Response;
import com.ponsun.aml.counterfeit.CounterfeitStatus.request.CreateCounterfeitStatusRequest;
import com.ponsun.aml.counterfeit.CounterfeitStatus.request.UpdateCounterfeitStatusRequest;

import java.util.List;

public interface CounterfeitStatusWriteService {
    Response createCounterfeitStatus(CreateCounterfeitStatusRequest createCounterfeitStatusRequest);
    Response updateCounterfeitStatus(Integer id, UpdateCounterfeitStatusRequest updateCounterfeitStatusRequest);
    List<CounterfeitStatusData> fetchAllCounterfeitStatusData(Integer counterfeitId);
    Response deActive(Integer counterfeitId, Integer euid);
}
