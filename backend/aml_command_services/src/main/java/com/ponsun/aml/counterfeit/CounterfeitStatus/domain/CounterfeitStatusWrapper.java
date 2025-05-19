package com.ponsun.aml.counterfeit.CounterfeitStatus.domain;


import com.ponsun.aml.counterfeit.CounterfeitStatus.request.AbstractCounterfeitStatusRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CounterfeitStatusWrapper extends AbstractCounterfeitStatusRequest {
    private final CounterfeitStatusRepository CounterfeitStatusRepository;
    @Transactional
    public CounterfeitStatus findOneWithNotFoundDetection(final Integer id){
        return this.CounterfeitStatusRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CounterfeitStatus Not found " + id) );
    }
    @Transactional
    public List<CounterfeitStatus> findCounterfeitIdNotFoundDetection(final Integer counterfeitId){
        return this.CounterfeitStatusRepository.findByCounterfeitId(counterfeitId);
    }
    @Override
    public String toString(){
        return super.toString();
    }


}
