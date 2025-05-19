package com.ponsun.aml.fraudTeam.FraudRemark.services;

import com.ponsun.aml.fraudTeam.FraudRemark.data.FraudRemarkData;
import com.ponsun.aml.fraudTeam.FraudRemark.data.FraudRemarkValidator;
import com.ponsun.aml.fraudTeam.FraudRemark.domain.FraudRemark;
import com.ponsun.aml.fraudTeam.FraudRemark.domain.FraudRemarkRepository;
import com.ponsun.aml.fraudTeam.FraudRemark.domain.FraudRemarkWrapper;
import com.ponsun.aml.fraudTeam.FraudRemark.request.CreateFraudRemarkRequest;
import com.ponsun.aml.fraudTeam.FraudRemark.request.UpdateFraudRemarkRequest;
import com.ponsun.aml.fraudTeam.FraudRemark.rowmapper.FraudRemarkRowMapper;
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
public class FraudRemarkWriteServiceImpl implements FraudRemarkWriteService {
    private final FraudRemarkRepository fraudRemarkRepository;
    private final FraudRemarkWrapper fraudRemarkWrapper;
    private final FraudRemarkValidator fraudRemarkValidator;
    private final FraudRemarkRowMapper fraudRemarkRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createFraudRemark(CreateFraudRemarkRequest createFraudRemarkRequest) {
        try {
            this.fraudRemarkValidator.validateSaveRemark(createFraudRemarkRequest);
            final FraudRemark fraudRemark = FraudRemark.create(createFraudRemarkRequest);
            this.fraudRemarkRepository.saveAndFlush(fraudRemark);
            return Response.of(Long.valueOf(fraudRemark.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateFraudRemark(Integer id, UpdateFraudRemarkRequest updateFraudRemarkRequest) {
        try {
            this.fraudRemarkValidator.validateUpdateRemark(updateFraudRemarkRequest);
            final FraudRemark fraudRemark = this.fraudRemarkWrapper.findOneWithNotFoundDetection(id);
            fraudRemark.update(updateFraudRemarkRequest);
            this.fraudRemarkRepository.saveAndFlush(fraudRemark);
            return Response.of(Long.valueOf(fraudRemark.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    public List<FraudRemarkData> fetchAllFraudRemarkData(Integer fraudId) {
        final FraudRemarkRowMapper rowMapper = new FraudRemarkRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE fr.fraudId = ?  AND fr.STATUS = 'A' ";
        Qry = Qry + whereClause;
        final List<FraudRemarkData> fraudRemarkData = jdbcTemplate.query(Qry, fraudRemarkRowMapper, new Object[]{fraudId});
        return fraudRemarkData;
    }

    @Override
    @Transactional
    public Response deActive(Integer fraudId, Integer euid) {
        try {
            List<FraudRemark> fraudRemarks = this.fraudRemarkWrapper.findFraudIdNotFoundDetection(fraudId);
            Response response = null;
            for (FraudRemark fraudRemark : fraudRemarks) {
                fraudRemark.setEuid(euid);
                fraudRemark.setStatus(Status.DELETE);
                fraudRemark.setUpdatedAt(LocalDateTime.now());
                response = Response.of(fraudRemark.getId());
            }
            return response;
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
}
