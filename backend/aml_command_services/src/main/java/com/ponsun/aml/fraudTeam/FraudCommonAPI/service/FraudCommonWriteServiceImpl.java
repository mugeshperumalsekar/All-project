package com.ponsun.aml.fraudTeam.FraudCommonAPI.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ponsun.aml.fraudTeam.FraudCommonAPI.FraudReadDTO;
import com.ponsun.aml.fraudTeam.FraudCommonAPI.FraudWriteDTO;
import com.ponsun.aml.fraudTeam.FraudObservation.data.FraudObservationData;
import com.ponsun.aml.fraudTeam.FraudObservation.request.CreateFraudObservationRequest;
import com.ponsun.aml.fraudTeam.FraudObservation.services.FraudObservationWriteService;
import com.ponsun.aml.fraudTeam.FraudRemark.data.FraudRemarkData;
import com.ponsun.aml.fraudTeam.FraudRemark.request.CreateFraudRemarkRequest;
import com.ponsun.aml.fraudTeam.FraudRemark.services.FraudRemarkWriteService;
import com.ponsun.aml.fraudTeam.FraudStatus.data.FraudStatusData;
import com.ponsun.aml.fraudTeam.FraudStatus.request.CreateFraudStatusRequest;
import com.ponsun.aml.fraudTeam.FraudStatus.services.FraudStatusWriteService;
import com.ponsun.aml.fraudTeam.FraudTeam.domain.FraudTeam;
import com.ponsun.aml.fraudTeam.FraudTeam.request.CreateFraudTeamRequest;
import com.ponsun.aml.fraudTeam.FraudTeam.request.UpdateFraudTeamRequest;
import com.ponsun.aml.fraudTeam.FraudTeam.services.FraudTeamReadService;
import com.ponsun.aml.fraudTeam.FraudTeam.services.FraudTeamWriteService;
import com.ponsun.aml.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@RequiredArgsConstructor
@Service
public class FraudCommonWriteServiceImpl implements FraudCommonWriteService {
    private final FraudTeamReadService fraudTeamReadService;
    private final FraudTeamWriteService fraudTeamWriteService;
    private final FraudStatusWriteService fraudStatusWriteService;
    private final FraudRemarkWriteService fraudRemarkWriteService;
    private final FraudObservationWriteService fraudObservationWriteService;

    @Override
    @Transactional
    public Response saveFraudDetails(String fraudDTO){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        try{
            FraudWriteDTO fraudWriteDTO = objectMapper.readValue(fraudDTO,FraudWriteDTO.class);
            CreateFraudTeamRequest createFraudTeamRequest = fraudWriteDTO.getCreateFraudTeamRequest();
            List<CreateFraudStatusRequest> createFraudStatusRequest = fraudWriteDTO.getCreateFraudStatusRequest();
            List<CreateFraudRemarkRequest> createFraudRemarkRequest = fraudWriteDTO.getCreateFraudRemarkRequest();
            List<CreateFraudObservationRequest> createFraudObservationRequest = fraudWriteDTO.getCreateFraudObservationRequest();
            Response response = this.fraudTeamWriteService.createFraudTeam(createFraudTeamRequest);
            Integer fraudId = (Integer) response.getId();
            if(!createFraudStatusRequest.isEmpty()) {
                for(CreateFraudStatusRequest dto:createFraudStatusRequest){
                  dto.setFraudId(fraudId);
                  this.fraudStatusWriteService.createFraudStatus(dto);
                }
            }

            if(!createFraudRemarkRequest.isEmpty()){
                for(CreateFraudRemarkRequest dto: createFraudRemarkRequest){
                   dto.setFraudId(fraudId);
                   this.fraudRemarkWriteService.createFraudRemark(dto);
                }
            }

            if(!createFraudObservationRequest.isEmpty()){
               for(CreateFraudObservationRequest dto: createFraudObservationRequest ) {
                   dto.setFraudId(fraudId);
                   this.fraudObservationWriteService.createFraudObservation(dto);
               }
            }
        } catch(JsonProcessingException e){
            throw new RuntimeException(e);
        }
        return new Response();
    }

    @Override
        public FraudReadDTO getFraud(Integer fraudId){
        ModelMapper modelMapper = new ModelMapper();
        FraudReadDTO fraudReadDTO = new FraudReadDTO();

        FraudTeam fraudTeam = this.fraudTeamReadService.fetchFraudTeamById(fraudId);
        List<FraudStatusData> fraudStatusData = this.fraudStatusWriteService.fetchAllFraudStatusData(fraudId);
        List<FraudRemarkData> fraudRemarkData = this.fraudRemarkWriteService.fetchAllFraudRemarkData(fraudId);
        List<FraudObservationData> fraudObservationData = this.fraudObservationWriteService.fetchAllFraudObservationData(fraudId);
        CreateFraudTeamRequest createFraudTeamRequest = modelMapper.map(fraudTeam, CreateFraudTeamRequest.class);

        fraudReadDTO.setCreateFraudTeamRequest(createFraudTeamRequest);
        fraudReadDTO.setFraudStatusData(fraudStatusData);
        fraudReadDTO.setFraudRemarkData(fraudRemarkData);
        fraudReadDTO.setFraudObservationData(fraudObservationData);
        return fraudReadDTO;
    }

    @Override
    @Transactional
    public Response updateFraudDetails(String fraudDTO,Integer fraudId,Integer euid){
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
        try{
            FraudWriteDTO fraudWriteDTO = objectMapper.readValue(fraudDTO, FraudWriteDTO.class);
            UpdateFraudTeamRequest updateFraudTeamRequest = fraudWriteDTO.getUpdateFraudTeamRequest();
            List<CreateFraudStatusRequest> createFraudStatusRequest = fraudWriteDTO.getCreateFraudStatusRequest();
            List<CreateFraudRemarkRequest> createFraudRemarkRequest = fraudWriteDTO.getCreateFraudRemarkRequest();
            List<CreateFraudObservationRequest> createFraudObservationRequest = fraudWriteDTO.getCreateFraudObservationRequest();

            if(updateFraudTeamRequest != null && !updateFraudTeamRequest.equals("")){
              this.fraudTeamWriteService.updateFraudTeam(fraudId,updateFraudTeamRequest);
            }
            if(createFraudStatusRequest != null && !createFraudStatusRequest.isEmpty()){
                this.fraudStatusWriteService.deActive(fraudId,euid);
                for(CreateFraudStatusRequest dto: createFraudStatusRequest){
                   dto.setFraudId(fraudId);
                   this.fraudStatusWriteService.createFraudStatus(dto);
                }
            }

            if(createFraudRemarkRequest != null && !createFraudRemarkRequest.isEmpty()){
              this.fraudRemarkWriteService.deActive(fraudId,euid);
              for(CreateFraudRemarkRequest dto : createFraudRemarkRequest){
                  dto.setFraudId(fraudId);
                  this.fraudRemarkWriteService.createFraudRemark(dto);
              }
            }

            if(createFraudObservationRequest != null && !createFraudObservationRequest.isEmpty()){
                this.fraudObservationWriteService.deActive(fraudId,euid);
                for(CreateFraudObservationRequest dto: createFraudObservationRequest){
                    dto.setFraudId(fraudId);
                    this.fraudObservationWriteService.createFraudObservation(dto);
                }
            }
        } catch (JsonProcessingException e){
            throw new RuntimeException(e);
        }
        return new Response();
    }
}
