package com.ponsun.aml.counterfeit.CommonAPI.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.ponsun.aml.counterfeit.CommonAPI.CounterfeitReadDTO;
import com.ponsun.aml.infrastructure.utils.Response;
import org.springframework.transaction.annotation.Transactional;

public interface CommonWriteService {

    Response saveCounterfeitDetails(String counterfeitDTO) throws JsonProcessingException;

    CounterfeitReadDTO getCounterfeit(Integer counterfeitId);

    Response updateCounterfeitDetails(String counterfeitDTO, Integer counterfeitId, Integer euid);
}
