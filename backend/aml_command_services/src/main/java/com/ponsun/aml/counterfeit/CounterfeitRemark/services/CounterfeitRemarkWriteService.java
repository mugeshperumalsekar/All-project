package com.ponsun.aml.counterfeit.CounterfeitRemark.services;

import com.ponsun.aml.counterfeit.CounterfeitRemark.data.CounterfeitRemarkData;
import com.ponsun.aml.infrastructure.utils.Response;
import com.ponsun.aml.counterfeit.CounterfeitRemark.request.CreateCounterfeitRemarkRequest;
import com.ponsun.aml.counterfeit.CounterfeitRemark.request.UpdateCounterfeitRemarkRequest;

import java.util.List;

public interface CounterfeitRemarkWriteService {
    Response createCounterfeitRemark(CreateCounterfeitRemarkRequest createCounterfeitRemarkRequest);

    Response updateCounterfeitRemark(Integer id, UpdateCounterfeitRemarkRequest updateCounterfeitRemarkRequest);

    List<CounterfeitRemarkData> fetchAllCounterfeitRemarkData(Integer counterfeitId);
    Response deActive(Integer counterfeitId, Integer euid);
}
