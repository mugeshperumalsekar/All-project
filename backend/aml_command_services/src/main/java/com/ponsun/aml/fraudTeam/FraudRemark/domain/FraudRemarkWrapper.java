package com.ponsun.aml.fraudTeam.FraudRemark.domain;

import com.ponsun.aml.fraudTeam.FraudRemark.request.AbstractFraudRemarkRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FraudRemarkWrapper extends AbstractFraudRemarkRequest {
    private final FraudRemarkRepository fraudRemarkRepository;

    @Transactional
    public FraudRemark findOneWithNotFoundDetection(final Integer id){
        return this.fraudRemarkRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("FraudRemark Not found "+id));
    }

    @Transactional
    public List<FraudRemark> findFraudIdNotFoundDetection(final Integer fraudId){
      return this.fraudRemarkRepository.findByFraudId(fraudId);
    }
    @Override
    public String toString(){return super.toString();}
}
