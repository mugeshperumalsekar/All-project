package com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.services;

import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.data.AmlConfigAlertScenariosValidator;
import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.domain.AmlConfigAlertScenarios;
import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.domain.AmlConfigAlertScenariosRepository;
import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.domain.AmlConfigAlertScenariosWrapper;
import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.request.CreateAbstractAmlConfigAlertScenariosRequest;
import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.request.UpdateAbstractAmlConfigAlertScenariosRequest;
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
public class AmlConfigAlertScenariosWriteServiceImpl implements AmlConfigAlertScenariosWriteService {
    private final AmlConfigAlertScenariosRepository alertScenariosRepository;
    private final AmlConfigAlertScenariosWrapper alertScenariosWrapper;
    private final AmlConfigAlertScenariosValidator alertScenariosValidator;

    @Override
    @Transactional
    public Response createAlertScenariosList(CreateAbstractAmlConfigAlertScenariosRequest createAlertScenariosRequest) {
        try {
            this.alertScenariosValidator.validateSaveAlertScenariosList(createAlertScenariosRequest);

            final AmlConfigAlertScenarios amlConfigAlertScenarios = AmlConfigAlertScenarios.create(createAlertScenariosRequest);//entity
            this.alertScenariosRepository.saveAndFlush(amlConfigAlertScenarios);
            return Response.of(Long.valueOf(amlConfigAlertScenarios.getId()));
        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

    @Override
    @Transactional
    public Response updateAlertScenariosList(Integer id, UpdateAbstractAmlConfigAlertScenariosRequest updateAlertScenariosRequest) {
        try {
            this.alertScenariosValidator.validateUpdateAlertScenariosList(updateAlertScenariosRequest);
            final AmlConfigAlertScenarios amlConfigAlertScenarios = this.alertScenariosWrapper.findOneWithNotFoundDetection(id);
            amlConfigAlertScenarios.update(updateAlertScenariosRequest);
            this.alertScenariosRepository.saveAndFlush(amlConfigAlertScenarios);
            return Response.of(Long.valueOf(amlConfigAlertScenarios.getId()));

        } catch (DataIntegrityViolationException e) {
            throw new EQAS_AML_AppicationException(e.getMessage());
        }
    }

}
