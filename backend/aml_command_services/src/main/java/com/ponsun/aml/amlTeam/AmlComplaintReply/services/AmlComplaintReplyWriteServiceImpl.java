package com.ponsun.aml.amlTeam.AmlComplaintReply.services;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.request.CreateAmlComplaintRemarkRequest;
import com.ponsun.aml.amlTeam.AmlComplaintRemark.services.AmlComplaintRemarkWriteService;
import com.ponsun.aml.amlTeam.AmlComplaintReply.data.AmlComplaintReplyValidator;
import com.ponsun.aml.amlTeam.AmlComplaintReply.data.ReplayWriteDTO;
import com.ponsun.aml.amlTeam.AmlComplaintReply.domain.AmlComplaintReply;
import com.ponsun.aml.amlTeam.AmlComplaintReply.domain.AmlComplaintReplyRepository;
import com.ponsun.aml.amlTeam.AmlComplaintReply.domain.AmlComplaintReplyWrapper;
import com.ponsun.aml.amlTeam.AmlComplaintReply.request.CreateAmlComplaintReplyRequest;
import com.ponsun.aml.amlTeam.AmlComplaintReply.request.UpdateAmlComplaintReplyrequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import com.ponsun.aml.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class AmlComplaintReplyWriteServiceImpl implements AmlComplaintReplyWriteService{
    private final AmlComplaintReplyRepository amlComplaintReplyRepository;
    private final AmlComplaintReplyWrapper amlComplaintReplyWrapper;
    private final AmlComplaintReplyValidator amlComplaintReplyValidator;
    private final AmlComplaintRemarkWriteService amlComplaintRemarkWriteService;
    private final JdbcTemplate jdbcTemplate;
    @Override
    @Transactional
    public Response createAmlComplaintReplyList(List<CreateAmlComplaintReplyRequest> createAmlComplaintReplyRequest) {
        try {
            AmlComplaintReply amlComplaintReply = new AmlComplaintReply();
            for(CreateAmlComplaintReplyRequest request : createAmlComplaintReplyRequest) {
                 amlComplaintReply = new AmlComplaintReply();
                this.amlComplaintReplyValidator.validateSaveAmlComplaintReplyList(request);
                  amlComplaintReply = AmlComplaintReply.create(request);//entity
                this.amlComplaintReplyRepository.saveAndFlush(amlComplaintReply);
            }
            return Response.of(Long.valueOf(amlComplaintReply.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response updateAmlComplaintReplyList(Integer id, UpdateAmlComplaintReplyrequest updateAmlComplaintReplyrequest) {
        try {
            this.amlComplaintReplyValidator.validateUpdateAmlComplaintReplyList(updateAmlComplaintReplyrequest);
            final AmlComplaintReply amlComplaintReply = this.amlComplaintReplyWrapper.findOneWithNotFoundDetection(id);
            amlComplaintReply.update(updateAmlComplaintReplyrequest);
            this.amlComplaintReplyRepository.saveAndFlush(amlComplaintReply);
            return Response.of(Long.valueOf(amlComplaintReply.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
    @Override
    @Transactional
    public Response createReplaySave(ReplayWriteDTO replayWriteDTO) {
        List<CreateAmlComplaintReplyRequest> replyRequests= replayWriteDTO.getCreateAmlComplaintReplyRequests();
        createAmlComplaintReplyList(replyRequests);
        CreateAmlComplaintRemarkRequest remarkRequest=replayWriteDTO.getCreateAmlComplaintRemarkRequest();
        Response response = this.amlComplaintRemarkWriteService.createAmlComplaintRemarkList(remarkRequest);
        return response;
    }

    @Override
    @Transactional
    public Response updateReplaySave(Integer complaintId,Integer euid,ReplayWriteDTO replayWriteDTO) {
        updatecomplaintteam(complaintId, euid);
//        System.out.println(complaintId);
        Response response = this.createReplaySave(replayWriteDTO);
        return response;
    }

    public void updatecomplaintteam(Integer complaintId, Integer euid) {
        String updateQuery = "UPDATE aml_complaint_reply SET STATUS='D', euid=?, updated_at=NOW() WHERE complaintId=?";
        this.jdbcTemplate.update(updateQuery, euid, complaintId);
    }
}
