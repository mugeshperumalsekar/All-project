package com.ponsun.aml.counterfeit.CounterfeitNumber.domain;


import com.ponsun.aml.counterfeit.CounterfeitNumber.request.AbstractCounterfeitNumberRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CounterfeitNumberWrapper extends AbstractCounterfeitNumberRequest {

    private final CounterfeitNumberRepository counterfeitNumberRepository;

    @Transactional
    public CounterfeitNumber findOneWithNotFoundDetection(final Integer id){
        return this.counterfeitNumberRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CounterfeitNumber Not found " + id) );
    }

    @Transactional
    public List<CounterfeitNumber> findCounterfeitIdNotFoundDetection(final Integer counterfeitId){
        return this.counterfeitNumberRepository.findByCounterfeitId(counterfeitId);
    }

    @Override
    public String toString(){
        return super.toString();
    }
}
