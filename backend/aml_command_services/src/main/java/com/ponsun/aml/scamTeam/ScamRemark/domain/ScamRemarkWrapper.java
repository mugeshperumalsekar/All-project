package com.ponsun.aml.scamTeam.ScamRemark.domain;

import com.ponsun.aml.scamTeam.ScamRemark.request.AbstractScamRemarkRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScamRemarkWrapper extends AbstractScamRemarkRequest {
    private final ScamRemarkRepository scamRemarkRepository;

    @Transactional
    public ScamRemark findOneWithNotFoundDetection(final Integer id){
        return this.scamRemarkRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("ScamRemark Not found "+id));
    }

    @Transactional
    public List<ScamRemark> findScamIdNotFoundDetection(final Integer scamId){
      return this.scamRemarkRepository.findByScamId(scamId);
    }
    @Override
    public String toString(){return super.toString();}
}
