package com.ponsun.aml.counterfeit.CommonAPI.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ponsun.aml.counterfeit.CommonAPI.CounterfeitReadDTO;
import com.ponsun.aml.counterfeit.CommonAPI.CounterfeitWriteDTO;
import com.ponsun.aml.counterfeit.CounterfeitNumber.data.CounterfeitNumberData;
import com.ponsun.aml.counterfeit.CounterfeitNumber.request.CreateCounterfeitNumberRequest;
import com.ponsun.aml.counterfeit.CounterfeitNumber.services.CounterfeitNumberWriteService;
import com.ponsun.aml.counterfeit.CounterfeitRemark.data.CounterfeitRemarkData;
import com.ponsun.aml.counterfeit.CounterfeitRemark.request.CreateCounterfeitRemarkRequest;
import com.ponsun.aml.counterfeit.CounterfeitRemark.services.CounterfeitRemarkWriteService;
import com.ponsun.aml.counterfeit.CounterfeitStatus.data.CounterfeitStatusData;
import com.ponsun.aml.counterfeit.CounterfeitStatus.request.CreateCounterfeitStatusRequest;
import com.ponsun.aml.counterfeit.CounterfeitStatus.services.CounterfeitStatusWriteService;
import com.ponsun.aml.counterfeit.CounterfeitTeam.domain.CounterfeitTeam;
import com.ponsun.aml.counterfeit.CounterfeitTeam.request.CreateCounterfeitTeamRequest;
import com.ponsun.aml.counterfeit.CounterfeitTeam.request.UpdateCounterfeitTeamRequest;
import com.ponsun.aml.counterfeit.CounterfeitTeam.services.CounterfeitTeamReadService;
import com.ponsun.aml.counterfeit.CounterfeitTeam.services.CounterfeitTeamWriteService;
import com.ponsun.aml.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class CommonWriteServiceImpl implements CommonWriteService {

    private final CounterfeitTeamReadService counterfeitTeamReadService;
    private final CounterfeitTeamWriteService counterfeitTeamWriteService;
    private final CounterfeitStatusWriteService counterfeitStatusWriteService;
    private final CounterfeitRemarkWriteService counterfeitRemarkWriteService;
    private final CounterfeitNumberWriteService counterfeitNumberWriteService;
    @Override
    @Transactional
    public Response saveCounterfeitDetails(String counterfeitDTO) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        try {
            CounterfeitWriteDTO counterfeitWriteDTO = objectMapper.readValue(counterfeitDTO, CounterfeitWriteDTO.class);
            CreateCounterfeitTeamRequest createCounterfeitTeamRequest = counterfeitWriteDTO.getCreateCounterfeitTeamRequest();
            List<CreateCounterfeitStatusRequest> createCounterfeitStatusRequest = counterfeitWriteDTO.getCreateCounterfeitStatusRequest();
            List<CreateCounterfeitRemarkRequest> createCounterfeitRemarkRequest = counterfeitWriteDTO.getCreateCounterfeitRemarkRequest();
            List<CreateCounterfeitNumberRequest> createCounterfeitNumberRequest = counterfeitWriteDTO.getCreateCounterfeitNumberRequests();
            Response response = this.counterfeitTeamWriteService.createCounterfeitTeam(createCounterfeitTeamRequest);
            Integer counterfeitId = (Integer) response.getId();

            if (!createCounterfeitStatusRequest.isEmpty()) {
                for (CreateCounterfeitStatusRequest dto : createCounterfeitStatusRequest) {
                    dto.setCounterfeitId(counterfeitId);
                    this.counterfeitStatusWriteService.createCounterfeitStatus(dto);
                }
            }

            if (!createCounterfeitRemarkRequest.isEmpty()) {
                for (CreateCounterfeitRemarkRequest dto : createCounterfeitRemarkRequest) {
                    dto.setCounterfeitId(counterfeitId);
                    this.counterfeitRemarkWriteService.createCounterfeitRemark(dto);
                }
            }

            if (!createCounterfeitNumberRequest.isEmpty()) {
                for (CreateCounterfeitNumberRequest dto : createCounterfeitNumberRequest) {
                    dto.setCounterfeitId(counterfeitId);
                    this.counterfeitNumberWriteService.createCounterfeitNumber(dto);
                }
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return new Response();
    }
    @Override
    public CounterfeitReadDTO getCounterfeit(Integer counterfeitId) {

        ModelMapper modelMapper = new ModelMapper();
        CounterfeitReadDTO counterfeitReadDTO = new CounterfeitReadDTO();

        CounterfeitTeam counterfeitTeam = this.counterfeitTeamReadService.fetchCounterfeitTeamById(counterfeitId);
        List<CounterfeitStatusData> counterfeitStatusData = this.counterfeitStatusWriteService.fetchAllCounterfeitStatusData(counterfeitId);
        List<CounterfeitRemarkData> counterfeitRemarkData = this.counterfeitRemarkWriteService.fetchAllCounterfeitRemarkData(counterfeitId);
        List<CounterfeitNumberData> counterfeitNumberData = this.counterfeitNumberWriteService.fetchAllCounterfeitNumberData(counterfeitId);
        CreateCounterfeitTeamRequest createCounterfeitTeamRequest = modelMapper.map(counterfeitTeam, CreateCounterfeitTeamRequest.class);

        counterfeitReadDTO.setCreateCounterfeitTeamRequest(createCounterfeitTeamRequest);
        counterfeitReadDTO.setCounterfeitStatusData(counterfeitStatusData);
        counterfeitReadDTO.setCounterfeitRemarkData(counterfeitRemarkData);
        counterfeitReadDTO.setCounterfeitNumberData(counterfeitNumberData);
        return counterfeitReadDTO;
    }
    @Override
    @Transactional
    public Response updateCounterfeitDetails(String counterfeitDTO, Integer counterfeitId, Integer euid) {

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);

        try {
            CounterfeitWriteDTO counterfeitWriteDTO = objectMapper.readValue(counterfeitDTO, CounterfeitWriteDTO.class);
            UpdateCounterfeitTeamRequest updateCounterfeitTeamRequest = counterfeitWriteDTO.getUpdateCounterfeitTeamRequest();
            List<CreateCounterfeitStatusRequest> createCounterfeitStatusRequest = counterfeitWriteDTO.getCreateCounterfeitStatusRequest();
            List<CreateCounterfeitRemarkRequest> createCounterfeitRemarkRequest = counterfeitWriteDTO.getCreateCounterfeitRemarkRequest();
            List<CreateCounterfeitNumberRequest> createCounterfeitNumberRequest = counterfeitWriteDTO.getCreateCounterfeitNumberRequests();

            if (updateCounterfeitTeamRequest != null && !updateCounterfeitTeamRequest.equals("")) {
                this.counterfeitTeamWriteService.updateCounterfeitTeam(counterfeitId, updateCounterfeitTeamRequest);
            }

            if (createCounterfeitStatusRequest != null && !createCounterfeitStatusRequest.isEmpty()) {
                this.counterfeitStatusWriteService.deActive(counterfeitId, euid);
                for (CreateCounterfeitStatusRequest dto : createCounterfeitStatusRequest) {
                    dto.setCounterfeitId(counterfeitId);
                    this.counterfeitStatusWriteService.createCounterfeitStatus(dto);
                }
            }

            if (createCounterfeitRemarkRequest != null && !createCounterfeitRemarkRequest.isEmpty()) {
                this.counterfeitRemarkWriteService.deActive(counterfeitId, euid);
                for (CreateCounterfeitRemarkRequest dto : createCounterfeitRemarkRequest) {
                    dto.setCounterfeitId(counterfeitId);
                    this.counterfeitRemarkWriteService.createCounterfeitRemark(dto);
                }
            }

            if (createCounterfeitNumberRequest != null && !createCounterfeitNumberRequest.isEmpty()) {
                this.counterfeitNumberWriteService.deActive(counterfeitId, euid);
                for (CreateCounterfeitNumberRequest dto : createCounterfeitNumberRequest) {
                    dto.setCounterfeitId(counterfeitId);
                    this.counterfeitNumberWriteService.createCounterfeitNumber(dto);
                }
            }

        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return new Response();
    }
}
