package com.ponsun.aml.counterfeit.CounterfeitNumber.services;

import com.ponsun.aml.counterfeit.CounterfeitNumber.data.CounterfeitNumberData;
import com.ponsun.aml.infrastructure.utils.Response;
import com.ponsun.aml.counterfeit.CounterfeitNumber.request.CreateCounterfeitNumberRequest;
import com.ponsun.aml.counterfeit.CounterfeitNumber.request.UpdateCounterfeitNumberRequest;

import java.util.List;

public interface CounterfeitNumberWriteService {
    Response createCounterfeitNumber(CreateCounterfeitNumberRequest createCounterfeitNumberRequest);
    Response updateCounterfeitNumber(Integer id, UpdateCounterfeitNumberRequest updateCounterfeitNumberRequest);
    List<CounterfeitNumberData> fetchAllCounterfeitNumberData(Integer counterfeitId);
    Response deActive(Integer counterfeitId, Integer euid);
}
