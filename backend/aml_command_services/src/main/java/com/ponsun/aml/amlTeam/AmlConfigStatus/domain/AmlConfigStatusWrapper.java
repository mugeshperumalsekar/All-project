package com.ponsun.aml.amlTeam.AmlConfigStatus.domain;

import com.ponsun.aml.amlTeam.AmlConfigStatus.request.AbstractAmlConfigStatusRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AmlConfigStatusWrapper extends AbstractAmlConfigStatusRequest {
    private final AmlConfigStatusRepository amlConfigStatusRepository;
    @Transactional
    public AmlConfigStatus findOneWithNotFoundDetection(final Integer id){
        return this.amlConfigStatusRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AmlCofigStatus Not found " +id));
    }

    @Override
    public String toString(){return super.toString();}
}
