package com.ponsun.aml.banktransaction.configalert.domain;

import com.ponsun.aml.banktransaction.configalert.request.AbstractConfigAlertRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class ConfigAlertRepositoryWrapper extends AbstractConfigAlertRequest {

    private final ConfigAlertRepository alertRepository;
    @Transactional
    public ConfigAlert findOneWithNotFoundDetection(final Integer id){
        return this.alertRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Alert Not found" + id));
    }

    @Override
    public String toString(){ return super.toString();}
}
