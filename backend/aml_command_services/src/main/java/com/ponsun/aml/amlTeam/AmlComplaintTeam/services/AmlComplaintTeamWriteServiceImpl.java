package com.ponsun.aml.amlTeam.AmlComplaintTeam.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.data.AmlComplaintAlertScenariosData;
import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.domain.AmlComplaintAlertScenarios;
import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.domain.AmlComplaintAlertScenariosRepository;
import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.request.CreateAmlComplaintAlertScenariosRequest;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.data.AmlComplaintRemarkData;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.domain.AmlComplaintRemark;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.domain.AmlComplaintRemarkRepository;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.request.CreateAmlComplaintRemarkRequest;
import com.ponsun.aml.amlTeam.AmlComplaintReply.data.AmlComplaintReplyData;
import com.ponsun.aml.amlTeam.AmlComplaintReply.domain.AmlComplaintReply;
import com.ponsun.aml.amlTeam.AmlComplaintReply.domain.AmlComplaintReplyRepository;
import com.ponsun.aml.amlTeam.AmlComplaintReply.request.CreateAmlComplaintReplyRequest;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.data.AmlComplaintDto;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.data.AmlComplaintTeamValidator;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.domain.AmlComplaintTeam;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.domain.AmlComplaintTeamRepository;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.domain.AmlComplaintTeamWrapper;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.request.CreateAmlComplaintTeamRequest;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.request.UpdateAmlComplaintTeamRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import com.ponsun.aml.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class AmlComplaintTeamWriteServiceImpl implements AmlComplaintTeamWriteService {
    private final AmlComplaintTeamRepository amlComplaintTeamRepository;
    private final AmlComplaintAlertScenariosRepository amlComplaintAlertScenariosRepository;
    private final AmlComplaintReplyRepository amlComplaintReplyRepository;
    private final AmlComplaintRemarkRepository amlComplaintRemarkRepository;
    private final AmlComplaintTeamWrapper amlConfigBranchWrapper;
    private final AmlComplaintTeamValidator amlBranchValidator;
    private final AmlComplaintTeamReadService readService;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createAmlBranchList(CreateAmlComplaintTeamRequest createAmlComplaintTeamRequest) {
        try {
            this.amlBranchValidator.validateSaveAmlBranchList(createAmlComplaintTeamRequest);

            if (createAmlComplaintTeamRequest.getTicketId() == 0)
                createAmlComplaintTeamRequest.setTicketId(readService.getmaxTicketId());

            createAmlComplaintTeamRequest.setTicketStatusId(1);//open new ticket

            AmlComplaintTeam amlComplaintTeam = AmlComplaintTeam.create(createAmlComplaintTeamRequest);//entity
            amlComplaintTeam = this.amlComplaintTeamRepository.saveAndFlush(amlComplaintTeam);

            return Response.of(Long.valueOf(amlComplaintTeam.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateAmlBranchList(Integer id, UpdateAmlComplaintTeamRequest updateAmlComplaintTeamRequest) {
        try {
            this.amlBranchValidator.validateUpdateAmlBranchList(updateAmlComplaintTeamRequest);
            final AmlComplaintTeam amlComplaintTeam = this.amlConfigBranchWrapper.findOneWithNotFoundDetection(id);
            amlComplaintTeam.update(updateAmlComplaintTeamRequest);
            this.amlComplaintTeamRepository.saveAndFlush(amlComplaintTeam);
            return Response.of(Long.valueOf(amlComplaintTeam.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response createAmlComplaint(AmlComplaintDto amlComplaintDto) {

        ModelMapper modelMapper = new ModelMapper();

        CreateAmlComplaintTeamRequest createAmlComplaintTeamRequest = amlComplaintDto.getCreateAmlComplaintTeamRequest();
        List<AmlComplaintAlertScenariosData> scenariosData = amlComplaintDto.getAmlComplaintAlertScenariosData();
//        List<AmlComplaintReplyData> replyData = amlComplaintDto.getAmlComplaintReplyData();
        List<AmlComplaintRemarkData> remarkData = amlComplaintDto.getAmlComplaintRemarkData();

        this.amlBranchValidator.validateSaveAmlBranchList(createAmlComplaintTeamRequest);

        Response response1 = createAmlBranchList(createAmlComplaintTeamRequest);

//        AmlComplaintTeam complaintTeam = AmlComplaintTeam.create(createAmlComplaintTeamRequest);//entity
//        complaintTeam = this.amlComplaintTeamRepository.saveAndFlush(complaintTeam);

        Integer complaintId = Integer.valueOf(response1.getId().toString());


        for (AmlComplaintAlertScenariosData request : scenariosData) {

            CreateAmlComplaintAlertScenariosRequest createAmlComplaintAlertScenariosRequest = modelMapper.map(request, CreateAmlComplaintAlertScenariosRequest.class);
            createAmlComplaintAlertScenariosRequest.setComplaintId(complaintId);
            AmlComplaintAlertScenarios amlComplaintAlertScenarios = AmlComplaintAlertScenarios.create(createAmlComplaintAlertScenariosRequest);
            this.amlComplaintAlertScenariosRepository.saveAndFlush(amlComplaintAlertScenarios);
        }

//        for (AmlComplaintReplyData request : replyData) {
//
//            CreateAmlComplaintReplyRequest createAmlComplaintReplyRequest = modelMapper.map(request, CreateAmlComplaintReplyRequest.class);
//            createAmlComplaintReplyRequest.setComplaintId(complaintId);
//            AmlComplaintReply amlComplaintReply = AmlComplaintReply.create(createAmlComplaintReplyRequest);
//            this.amlComplaintReplyRepository.saveAndFlush(amlComplaintReply);
//
//        }

        for (AmlComplaintRemarkData request1 : remarkData) {

            CreateAmlComplaintRemarkRequest createAmlComplaintRemarkRequest = modelMapper.map(request1, CreateAmlComplaintRemarkRequest.class);
            createAmlComplaintRemarkRequest.setComplaintId(complaintId);
            AmlComplaintRemark amlComplaintRemark = AmlComplaintRemark.create(createAmlComplaintRemarkRequest);
            this.amlComplaintRemarkRepository.saveAndFlush(amlComplaintRemark);

        }
        Response response = Response.of(complaintId);
        return response;
    }

    @Override
    @Transactional
    public Response updateAmlComplaint(Integer euid, Integer compId, AmlComplaintDto amlComplaintDto) {

        ObjectMapper objectMapper = new ObjectMapper();

//        AmlComplaintDto amlComplaintDto = null;
//        try {
//            amlComplaintDto = objectMapper.readValue(AmlDto, AmlComplaintDto.class);
//        } catch (JsonProcessingException e) {
//            throw new RuntimeException(e);
//        }

        ModelMapper modelMapper = new ModelMapper();

        CreateAmlComplaintTeamRequest createAmlComplaintTeamRequest = amlComplaintDto.getCreateAmlComplaintTeamRequest();
        createAmlComplaintTeamRequest.setId(compId);
        List<AmlComplaintAlertScenariosData> scenariosData = amlComplaintDto.getAmlComplaintAlertScenariosData();
//        List<AmlComplaintReplyData> replyData = amlComplaintDto.getAmlComplaintReplyData();
        List<AmlComplaintRemarkData> remarkData = amlComplaintDto.getAmlComplaintRemarkData();

        //this.amlBranchValidator.validateSaveAmlBranchList(createAmlComplaintTeamRequest);
        DeActiveFunction( compId,  euid);

        Response response1  = createAmlBranchList(createAmlComplaintTeamRequest);
        Integer complaintId = compId;//Integer.valueOf(response1.getId().toString());

        for (AmlComplaintAlertScenariosData request : scenariosData) {

            CreateAmlComplaintAlertScenariosRequest createAmlComplaintAlertScenariosRequest = modelMapper.map(request, CreateAmlComplaintAlertScenariosRequest.class);
            createAmlComplaintAlertScenariosRequest.setComplaintId(complaintId);
            AmlComplaintAlertScenarios amlComplaintAlertScenarios = AmlComplaintAlertScenarios.create(createAmlComplaintAlertScenariosRequest);
            this.amlComplaintAlertScenariosRepository.saveAndFlush(amlComplaintAlertScenarios);
        }

//        for (AmlComplaintReplyData request : replyData) {
//
//            CreateAmlComplaintReplyRequest createAmlComplaintReplyRequest = modelMapper.map(request, CreateAmlComplaintReplyRequest.class);
//            createAmlComplaintReplyRequest.setComplaintId(complaintId);
//            AmlComplaintReply amlComplaintReply = AmlComplaintReply.create(createAmlComplaintReplyRequest);
//            this.amlComplaintReplyRepository.saveAndFlush(amlComplaintReply);
//
//        }

        for (AmlComplaintRemarkData request1 : remarkData) {

            CreateAmlComplaintRemarkRequest createAmlComplaintRemarkRequest = modelMapper.map(request1, CreateAmlComplaintRemarkRequest.class);
            createAmlComplaintRemarkRequest.setComplaintId(complaintId);
            AmlComplaintRemark amlComplaintRemark = AmlComplaintRemark.create(createAmlComplaintRemarkRequest);
            this.amlComplaintRemarkRepository.saveAndFlush(amlComplaintRemark);

        }
        Response response = Response.of(complaintId);
        return response;
    }

    public void updatecomplaintteam(Integer compId, Integer euid) {
        String updateQuery = "UPDATE aml_complaint_team SET STATUS='D', euid=?, updated_at=NOW() WHERE id=?";
        this.jdbcTemplate.update(updateQuery, euid, compId);
    }

    public void updateAlertScenarios(Integer compId, Integer euid) {
        String updateQuery = "UPDATE aml_complaint_alert_scenarios SET STATUS='D', euid=?, updated_at=NOW() WHERE complaintId=?";
        this.jdbcTemplate.update(updateQuery, euid, compId);
    }

    public void updateReply(Integer compId, Integer euid) {
        String updateQuery = "UPDATE  aml_complaint_reply  SET STATUS='D', euid=?, updated_at=NOW() WHERE complaintId=?";
        this.jdbcTemplate.update(updateQuery, euid, compId);
    }

    public void updateRemark(Integer compId, Integer euid) {
        String updateQuery = "UPDATE  aml_complaint_remark SET STATUS='D', euid=?, updated_at=NOW() WHERE complaintId=?";
        this.jdbcTemplate.update(updateQuery, euid, compId);
    }

    public Response DeActiveFunction(Integer compId, Integer euid) {
        try {

            Response response = null;
            updatecomplaintteam(compId, euid);
            updateAlertScenarios(compId, euid);
            // updateReply(compId, euid);
            updateRemark(compId,euid);
            return response;

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
}
