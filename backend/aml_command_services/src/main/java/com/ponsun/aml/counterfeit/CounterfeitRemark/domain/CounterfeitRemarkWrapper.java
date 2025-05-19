package com.ponsun.aml.counterfeit.CounterfeitRemark.domain;


import com.ponsun.aml.counterfeit.CounterfeitRemark.request.AbstractCounterfeitRemarkRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CounterfeitRemarkWrapper extends AbstractCounterfeitRemarkRequest {

    private final CounterfeitRemarkRepository CounterfeitRemarkRepository;

    @Transactional
    public CounterfeitRemark findOneWithNotFoundDetection(final Integer id){
        return this.CounterfeitRemarkRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("CounterfeitRemark Not found " + id) );
    }

    @Transactional
    public List<CounterfeitRemark> findCounterfeitIdNotFoundDetection(final Integer counterfeitId){
        return this.CounterfeitRemarkRepository.findByCounterfeitId(counterfeitId);
    }


    @Override
    public String toString(){
        return super.toString();
    }
}
