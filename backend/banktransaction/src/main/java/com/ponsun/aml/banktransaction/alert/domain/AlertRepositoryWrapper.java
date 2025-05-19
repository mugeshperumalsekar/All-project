package com.ponsun.aml.banktransaction.alert.domain;

import com.ponsun.aml.banktransaction.alert.request.AbstractAlertRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AlertRepositoryWrapper extends AbstractAlertRequest {

    private final AlertRepository alertRepository;
    @Transactional
    public Alert findOneWithNotFoundDetection(final Integer id){
        return this.alertRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Alert Not found" + id));
    }

    @Override
    public String toString(){ return super.toString();}
}
