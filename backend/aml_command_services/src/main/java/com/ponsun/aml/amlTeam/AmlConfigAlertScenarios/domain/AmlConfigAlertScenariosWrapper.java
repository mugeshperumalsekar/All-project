package com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.domain;

import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.request.AbstractAmlConfigAlertScenariosRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AmlConfigAlertScenariosWrapper extends AbstractAmlConfigAlertScenariosRequest {
    private final AmlConfigAlertScenariosRepository alertScenariosRepository;
    @Transactional
    public AmlConfigAlertScenarios findOneWithNotFoundDetection(final Integer id){
        return this.alertScenariosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AmlConfigAlertScenarios Not found " + id) );
    }
    @Override
    public String toString(){
        return super.toString();
    }
}
