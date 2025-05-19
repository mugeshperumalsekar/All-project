package com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.services;

import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.data.AmlComplaintAlertScenariosValidator;
import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.domain.AmlComplaintAlertScenarios;
import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.domain.AmlComplaintAlertScenariosRepository;
import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.domain.AmlComplaintAlertScenariosWrapper;
import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.request.CreateAmlComplaintAlertScenariosRequest;
import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.request.UpdateAmlComplaintAlertScenariosRequest;
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
public class AmlComplaintAlertScenariosWriteServiceImpl implements AmlComplaintAlertScenariosWriteService{
    private final AmlComplaintAlertScenariosRepository amlComplaintAlertScenariosRepository;
    private final AmlComplaintAlertScenariosWrapper amlComplaintAlertScenariosWrapper;
    private final AmlComplaintAlertScenariosValidator amlComplaintAlertScenariosValidator;

    @Override
    @Transactional
    public Response createAlertScenariosList(CreateAmlComplaintAlertScenariosRequest createAmlComplaintAlertScenariosRequest) {
        try {
            this.amlComplaintAlertScenariosValidator.validateSaveAlertScenariosList(createAmlComplaintAlertScenariosRequest);
            final AmlComplaintAlertScenarios amlComplaintAlertScenarios = AmlComplaintAlertScenarios.create(createAmlComplaintAlertScenariosRequest);//entity
            this.amlComplaintAlertScenariosRepository.saveAndFlush(amlComplaintAlertScenarios);
            return Response.of(Long.valueOf(amlComplaintAlertScenarios.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateAlertScenariosList(Integer id, UpdateAmlComplaintAlertScenariosRequest updateAmlComplaintAlertScenariosRequest) {
        try {
            this.amlComplaintAlertScenariosValidator.validateUpdateAlertScenariosList(updateAmlComplaintAlertScenariosRequest);
            final AmlComplaintAlertScenarios amlComplaintAlertScenarios = this.amlComplaintAlertScenariosWrapper.findOneWithNotFoundDetection(id);
            amlComplaintAlertScenarios.update(updateAmlComplaintAlertScenariosRequest);
            this.amlComplaintAlertScenariosRepository.saveAndFlush(amlComplaintAlertScenarios);
            return Response.of(Long.valueOf(amlComplaintAlertScenarios.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }
}
