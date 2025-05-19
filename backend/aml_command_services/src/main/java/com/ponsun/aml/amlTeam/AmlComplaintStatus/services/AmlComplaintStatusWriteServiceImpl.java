package com.ponsun.aml.amlTeam.AmlComplaintStatus.services;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.data.AmlComplaintStatusValidator;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.domain.AmlComplaintStatus;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.domain.AmlComplaintStatusRepository;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.domain.AmlComplaintStatusWrapper;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.request.CreaetAmlComplaintStatuRequest;
import com.ponsun.aml.amlTeam.AmlComplaintStatus.request.UpdateAmlComplaintStatusRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import com.ponsun.aml.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AmlComplaintStatusWriteServiceImpl implements AmlComplaintStatusWriteService {
    private final AmlComplaintStatusRepository amlComplaintStatusRepository;
    private final AmlComplaintStatusWrapper amlComplaintStatusWrapper;
    private final AmlComplaintStatusValidator amlComplaintStatusValidator;
    private final AmlComplaintStatusReadService readService;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createAmlStatusList(CreaetAmlComplaintStatuRequest request) {
        try {
            this.amlComplaintStatusValidator.validateSaveAmlConfigStatusList(request);
            if (request.getTicketStatusId() != 1) {

                Integer ticketId = request.getTicketId();
                Integer ticketStatusId = request.getTicketStatusId();

                updateComplaintTeamTicketStatus( ticketId, ticketStatusId);
            }
            final AmlComplaintStatus amlComplaintStatus = AmlComplaintStatus.create(request);//entity
            this.amlComplaintStatusRepository.saveAndFlush(amlComplaintStatus);

            return Response.of(Long.valueOf(amlComplaintStatus.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateAmlStatusList(Integer id, UpdateAmlComplaintStatusRequest updateAmlConfigStatusRequest) {
        try {
            this.amlComplaintStatusValidator.validateUpdateAmlConfigStatusList(updateAmlConfigStatusRequest);
            final AmlComplaintStatus amlComplaintStatus = this.amlComplaintStatusWrapper.findOneWithNotFoundDetection(id);
            amlComplaintStatus.update(updateAmlConfigStatusRequest);
            this.amlComplaintStatusRepository.saveAndFlush(amlComplaintStatus);
            return Response.of(Long.valueOf(amlComplaintStatus.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    public void updateComplaintTeamTicketStatus(Integer ticketId, Integer ticketStatusId) {
        String updateQuery = "UPDATE `aml_complaint_team` SET ticketStatusId=? WHERE ticketId=?";
        this.jdbcTemplate.update(updateQuery, ticketId, ticketStatusId);
    }
}




