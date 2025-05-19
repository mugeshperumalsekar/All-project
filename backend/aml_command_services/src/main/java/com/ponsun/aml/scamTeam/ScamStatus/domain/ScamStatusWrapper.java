package com.ponsun.aml.scamTeam.ScamStatus.domain;

import com.ponsun.aml.scamTeam.ScamStatus.request.AbstractScamStatusRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScamStatusWrapper extends AbstractScamStatusRequest {
    private final ScamStatusRepository scamStatusRepository;

    @Transactional
    public ScamStatus findOneWithNotFoundDetection(final Integer id){
        return this.scamStatusRepository.findById(id).orElseThrow(() ->new EntityNotFoundException("ScamStatus Not found "+id));
    }

    @Transactional
    public List<ScamStatus> findScamIdNotFoundDetection(final Integer scamId){
        return this.scamStatusRepository.findByScamId(scamId);
    }

    @Override
    public String toString(){return super.toString();}
}
