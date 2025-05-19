package com.ponsun.aml.scamTeam.ScamCommonAPI.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ponsun.aml.scamTeam.ScamObservation.data.ScamObservationData;
import com.ponsun.aml.scamTeam.ScamCommonAPI.ScamWriteDTO;
import com.ponsun.aml.scamTeam.ScamCommonAPI.ScamReadDTO;
import com.ponsun.aml.scamTeam.ScamObservation.request.CreateScamObservationRequest;
import com.ponsun.aml.scamTeam.ScamObservation.services.ScamObservationWriteService;
import com.ponsun.aml.scamTeam.ScamRemark.data.ScamRemarkData;
import com.ponsun.aml.scamTeam.ScamRemark.request.CreateScamRemarkRequest;
import com.ponsun.aml.scamTeam.ScamRemark.services.ScamRemarkWriteService;
import com.ponsun.aml.scamTeam.ScamStatus.data.ScamStatusData;
import com.ponsun.aml.scamTeam.ScamStatus.request.CreateScamStatusRequest;
import com.ponsun.aml.scamTeam.ScamStatus.services.ScamStatusWriteService;
import com.ponsun.aml.scamTeam.ScamTeam.domain.ScamTeam;
import com.ponsun.aml.scamTeam.ScamTeam.request.CreateScamTeamRequest;
import com.ponsun.aml.scamTeam.ScamTeam.request.UpdateScamTeamRequest;
import com.ponsun.aml.scamTeam.ScamTeam.services.ScamTeamReadService;
import com.ponsun.aml.scamTeam.ScamTeam.services.ScamTeamWriteService;
import com.ponsun.aml.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ScamCommonWriteServiceImpl implements ScamCommonWriteService {
    private final ScamTeamReadService scamTeamReadService;
    private final ScamTeamWriteService scamTeamWriteService;
    private final ScamStatusWriteService scamStatusWriteService;
    private final ScamRemarkWriteService scamRemarkWriteService;
    private final ScamObservationWriteService scamObservationWriteService;

    @Override
    @Transactional
    public Response saveScamDetails(String scamDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        try{
            ScamWriteDTO scamWriteDTO = objectMapper.readValue(scamDTO,ScamWriteDTO.class);
            CreateScamTeamRequest createScamTeamRequest = scamWriteDTO.getCreateScamTeamRequest();
            List<CreateScamStatusRequest> createScamStatusRequest = scamWriteDTO.getCreateScamStatusRequest();
            List<CreateScamRemarkRequest> createScamRemarkRequest = scamWriteDTO.getCreateScamRemarkRequest();
            List<CreateScamObservationRequest> createScamObservationRequest = scamWriteDTO.getCreateScamObservationRequest();
            Response response = this.scamTeamWriteService.createScamTeam(createScamTeamRequest);
            Integer scamId = (Integer) response.getId();
            if(!createScamStatusRequest.isEmpty()) {
                for(CreateScamStatusRequest dto:createScamStatusRequest){
                  dto.setScamId(scamId);
                  this.scamStatusWriteService.createScamStatus(dto);
                }
            }

            if(!createScamRemarkRequest.isEmpty()){
                for(CreateScamRemarkRequest dto: createScamRemarkRequest){
                   dto.setScamId(scamId);
                   this.scamRemarkWriteService.createScamRemark(dto);
                }
            }

            if(!createScamObservationRequest.isEmpty()){
               for(CreateScamObservationRequest dto: createScamObservationRequest ) {
                   dto.setScamId(scamId);
                   this.scamObservationWriteService.createScamObservation(dto);
               }
            }
        } catch(JsonProcessingException e){
            throw new RuntimeException(e);
        }
        return new Response();
    }

    @Override
        public ScamReadDTO getScam(Integer scamId){
        ModelMapper modelMapper = new ModelMapper();
        ScamReadDTO scamReadDTO = new ScamReadDTO();

        ScamTeam scamTeam = this.scamTeamReadService.fetchScamTeamById(scamId);
        List<ScamStatusData> scamStatusData = this.scamStatusWriteService.fetchAllScamStatusData(scamId);
        List<ScamRemarkData> scamRemarkData = this.scamRemarkWriteService.fetchAllScamRemarkData(scamId);
        List<ScamObservationData> scamObservationData = this.scamObservationWriteService.fetchAllScamObservationData(scamId);
        CreateScamTeamRequest createScamTeamRequest = modelMapper.map(scamTeam, CreateScamTeamRequest.class);

        scamReadDTO.setCreateScamTeamRequest(createScamTeamRequest);
        scamReadDTO.setScamStatusData(scamStatusData);
        scamReadDTO.setScamRemarkData(scamRemarkData);
        scamReadDTO.setScamObservationData(scamObservationData);
        return scamReadDTO;
    }

    @Override
    @Transactional
    public Response updateScamDetails(String scamDTO,Integer scamId,Integer euid){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        try{
            ScamWriteDTO scamWriteDTO = objectMapper.readValue(scamDTO, ScamWriteDTO.class);
            UpdateScamTeamRequest updateScamTeamRequest = scamWriteDTO.getUpdateScamTeamRequest();
            List<CreateScamStatusRequest> createScamStatusRequest = scamWriteDTO.getCreateScamStatusRequest();
            List<CreateScamRemarkRequest> createScamRemarkRequest = scamWriteDTO.getCreateScamRemarkRequest();
            List<CreateScamObservationRequest> createScamObservationRequest = scamWriteDTO.getCreateScamObservationRequest();

            if(updateScamTeamRequest != null && !updateScamTeamRequest.equals("")){
              this.scamTeamWriteService.updateScamTeam(scamId,updateScamTeamRequest);
            }
            if(createScamStatusRequest != null && !createScamStatusRequest.isEmpty()){
                this.scamStatusWriteService.deActive(scamId,euid);
                for(CreateScamStatusRequest dto: createScamStatusRequest){
                   dto.setScamId(scamId);
                   this.scamStatusWriteService.createScamStatus(dto);
                }
            }

            if(createScamRemarkRequest != null && !createScamRemarkRequest.isEmpty()){
              this.scamRemarkWriteService.deActive(scamId,euid);
              for(CreateScamRemarkRequest dto : createScamRemarkRequest){
                  dto.setScamId(scamId);
                  this.scamRemarkWriteService.createScamRemark(dto);
              }
            }

            if(createScamObservationRequest != null && !createScamObservationRequest.isEmpty()){
                this.scamObservationWriteService.deActive(scamId,euid);
                for(CreateScamObservationRequest dto: createScamObservationRequest){
                    dto.setScamId(scamId);
                    this.scamObservationWriteService.createScamObservation(dto);
                }
            }
        } catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
        return new Response();
    }
}
