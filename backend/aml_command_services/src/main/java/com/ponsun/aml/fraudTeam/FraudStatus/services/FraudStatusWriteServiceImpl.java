package com.ponsun.aml.fraudTeam.FraudStatus.services;

import com.ponsun.aml.fraudTeam.FraudStatus.data.FraudStatusData;
import com.ponsun.aml.fraudTeam.FraudStatus.data.FraudStatusValidator;
import com.ponsun.aml.fraudTeam.FraudStatus.domain.FraudStatus;
import com.ponsun.aml.fraudTeam.FraudStatus.domain.FraudStatusRepository;
import com.ponsun.aml.fraudTeam.FraudStatus.domain.FraudStatusWrapper;
import com.ponsun.aml.fraudTeam.FraudStatus.request.CreateFraudStatusRequest;
import com.ponsun.aml.fraudTeam.FraudStatus.request.UpdateFraudStatusRequest;
import com.ponsun.aml.fraudTeam.FraudStatus.rowmapper.FraudStatusRowMapper;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import com.ponsun.aml.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FraudStatusWriteServiceImpl implements FraudStatusWriteService {
    private final FraudStatusRepository fraudStatusRepository;
    private final FraudStatusWrapper fraudStatusWrapper;
    private final FraudStatusValidator fraudStatusValidator;
    private final FraudStatusRowMapper fraudStatusRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createFraudStatus(CreateFraudStatusRequest createFraudStatusRequest) {
        try {
            this.fraudStatusValidator.validateSaveStatus(createFraudStatusRequest);
            final FraudStatus fraudStatus = FraudStatus.create(createFraudStatusRequest);
            this.fraudStatusRepository.saveAndFlush(fraudStatus);
            return Response.of(Long.valueOf(fraudStatus.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateFraudStatus(Integer id, UpdateFraudStatusRequest updateFraudStatusRequest) {
        try {
            this.fraudStatusValidator.validateUpdateStatus(updateFraudStatusRequest);
            final FraudStatus fraudStatus = this.fraudStatusWrapper.findOneWithNotFoundDetection(id);
            fraudStatus.update(updateFraudStatusRequest);
            this.fraudStatusRepository.saveAndFlush(fraudStatus);
            return Response.of(Long.valueOf(fraudStatus.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    public List<FraudStatusData> fetchAllFraudStatusData(Integer fraudId) {
        final FraudStatusRowMapper rowMapper = new FraudStatusRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE fs.fraudId = ?  AND fs.STATUS = 'A'";
        Qry = Qry + whereClause;
        final List<FraudStatusData> fraudStatusData = jdbcTemplate.query(Qry, fraudStatusRowMapper, new Object[]{fraudId});
        return fraudStatusData;
    }

    @Override
    @Transactional
    public Response deActive(Integer fraudId, Integer euid) {
        try {
            List<FraudStatus> fraudStatuses = this.fraudStatusWrapper.findFraudIdNotFoundDetection(fraudId);
            Response response = null;
            for (FraudStatus fraudStatus : fraudStatuses) {
                fraudStatus.setEuid(euid);
                fraudStatus.setStatus(Status.DELETE);
                fraudStatus.setUpdatedAt(LocalDateTime.now());
                response = Response.of(fraudStatus.getId());
            }
            return response;
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
}
