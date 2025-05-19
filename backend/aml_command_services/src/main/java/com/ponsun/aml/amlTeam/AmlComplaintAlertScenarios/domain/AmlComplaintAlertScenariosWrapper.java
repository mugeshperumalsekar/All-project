package com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.domain;

import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.request.AbstractAmlComplaintAlertScenariosRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
@Service
@RequiredArgsConstructor

public class AmlComplaintAlertScenariosWrapper extends AbstractAmlComplaintAlertScenariosRequest {
    private final AmlComplaintAlertScenariosRepository amlComplaintAlertScenariosRepository;
    @Transactional
    public AmlComplaintAlertScenarios findOneWithNotFoundDetection(final Integer id){
        return this.amlComplaintAlertScenariosRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AmlComplaintAlertScenarios Not found " + id) );
    }
    @Override
    public String toString(){
        return super.toString();
    }

}
