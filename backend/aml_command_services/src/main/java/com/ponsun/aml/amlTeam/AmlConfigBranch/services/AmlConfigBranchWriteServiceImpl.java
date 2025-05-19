package com.ponsun.aml.amlTeam.AmlConfigBranch.services;

import com.ponsun.aml.amlTeam.AmlConfigBranch.data.AmlConfigBranchValidator;
import com.ponsun.aml.amlTeam.AmlConfigBranch.domain.AmlConfigBranch;
import com.ponsun.aml.amlTeam.AmlConfigBranch.domain.AmlConfigBranchRepository;
import com.ponsun.aml.amlTeam.AmlConfigBranch.domain.AmlConfigBranchWrapper;
import com.ponsun.aml.amlTeam.AmlConfigBranch.request.CreateAmlConfigBranchRequest;
import com.ponsun.aml.amlTeam.AmlConfigBranch.request.UpdateAmlConfigBranchRequest;
import com.ponsun.aml.infrastructure.exceptions.EQAS_AML_AppicationException;
import com.ponsun.aml.infrastructure.utils.Response;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Slf4j
public class AmlConfigBranchWriteServiceImpl implements AmlConfigBranchWriteService {
    private final AmlConfigBranchRepository amlConfigBranchRepository;
    private final AmlConfigBranchWrapper amlConfigBranchWrapper;
    private final AmlConfigBranchValidator amlConfigBranchValidator;

    @Override
    @Transactional
    public Response createConfigBranch(CreateAmlConfigBranchRequest createCurrencyReportBranchToAmlRequest) {
        try {
            this.amlConfigBranchValidator.validateSaveConfigBranch(createCurrencyReportBranchToAmlRequest);
            final AmlConfigBranch amlConfigBranch = AmlConfigBranch.create(createCurrencyReportBranchToAmlRequest);//entity
            this.amlConfigBranchRepository.saveAndFlush(amlConfigBranch);
            return Response.of(Long.valueOf(amlConfigBranch.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateConfigBranch(Integer id, UpdateAmlConfigBranchRequest updateCurrencyReportBranchToAmlRequest) {
        try {
            this.amlConfigBranchValidator.validateUpdateConfigBranch(updateCurrencyReportBranchToAmlRequest);
            final AmlConfigBranch amlConfigBranch = this.amlConfigBranchWrapper.findOneWithNotFoundDetection(id);
            amlConfigBranch.update(updateCurrencyReportBranchToAmlRequest);
            this.amlConfigBranchRepository.saveAndFlush(amlConfigBranch);
            return Response.of(Long.valueOf(amlConfigBranch.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
}
