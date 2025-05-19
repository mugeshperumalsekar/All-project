package com.ponsun.aml.scamTeam.ScamRemark.services;

import com.ponsun.aml.scamTeam.ScamRemark.data.ScamRemarkData;
import com.ponsun.aml.scamTeam.ScamRemark.data.ScamRemarkValidator;
import com.ponsun.aml.scamTeam.ScamRemark.domain.ScamRemark;
import com.ponsun.aml.scamTeam.ScamRemark.domain.ScamRemarkRepository;
import com.ponsun.aml.scamTeam.ScamRemark.domain.ScamRemarkWrapper;
import com.ponsun.aml.scamTeam.ScamRemark.request.CreateScamRemarkRequest;
import com.ponsun.aml.scamTeam.ScamRemark.request.UpdateScamRemarkRequest;
import com.ponsun.aml.scamTeam.ScamRemark.rowmapper.ScamRemarkRowMapper;
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
public class ScamRemarkWriteServiceImpl implements ScamRemarkWriteService {
    private final ScamRemarkRepository scamRemarkRepository;
    private final ScamRemarkWrapper scamRemarkWrapper;
    private final ScamRemarkValidator scamRemarkValidator;
    private final ScamRemarkRowMapper scamRemarkRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    @Transactional
    public Response createScamRemark(CreateScamRemarkRequest createScamRemarkRequest) {
        try {
            this.scamRemarkValidator.validateSaveRemark(createScamRemarkRequest);
            final ScamRemark scamRemark = ScamRemark.create(createScamRemarkRequest);
            this.scamRemarkRepository.saveAndFlush(scamRemark);
            return Response.of(Long.valueOf(scamRemark.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateScamRemark(Integer id, UpdateScamRemarkRequest updateScamRemarkRequest) {
        try {
            this.scamRemarkValidator.validateUpdateRemark(updateScamRemarkRequest);
            final ScamRemark scamRemark = this.scamRemarkWrapper.findOneWithNotFoundDetection(id);
            scamRemark.update(updateScamRemarkRequest);
            this.scamRemarkRepository.saveAndFlush(scamRemark);
            return Response.of(Long.valueOf(scamRemark.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    public List<ScamRemarkData> fetchAllScamRemarkData(Integer scamId) {
        final ScamRemarkRowMapper rowMapper = new ScamRemarkRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE sr.scamId = ?  AND sr.STATUS = 'A' ";
        Qry = Qry + whereClause;
        final List<ScamRemarkData> scamRemarkData = jdbcTemplate.query(Qry, scamRemarkRowMapper, new Object[]{scamId});
        return scamRemarkData;
    }

    @Override
    @Transactional
    public Response deActive(Integer scamId, Integer euid) {
        try {
            List<ScamRemark> scamRemarks = this.scamRemarkWrapper.findScamIdNotFoundDetection(scamId);
            Response response = null;
            for (ScamRemark scamRemark : scamRemarks) {
                scamRemark.setEuid(euid);
                scamRemark.setStatus(Status.DELETE);
                scamRemark.setUpdatedAt(LocalDateTime.now());
                response = Response.of(scamRemark.getId());
            }
            return response;
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
}
