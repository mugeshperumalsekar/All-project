package com.ponsun.aml.fraudTeam.FraudStatus.domain;

import com.ponsun.aml.fraudTeam.FraudStatus.request.AbstractFraudStatusRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FraudStatusWrapper extends AbstractFraudStatusRequest {
    private final FraudStatusRepository fraudStatusRepository;

    @Transactional
    public FraudStatus findOneWithNotFoundDetection(final Integer id){
        return this.fraudStatusRepository.findById(id).orElseThrow(() ->new EntityNotFoundException("FraudStatus Not found "+id));
    }

    @Transactional
    public List<FraudStatus> findFraudIdNotFoundDetection(final Integer fraudId){
        return this.fraudStatusRepository.findByFraudId(fraudId);
    }

    @Override
    public String toString(){return super.toString();}
}
