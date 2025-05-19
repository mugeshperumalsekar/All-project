package com.ponsun.aml.banktransaction.levelGet.domain;


import com.ponsun.aml.banktransaction.levelGet.request.AbstractLevelGetRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class LevelGetRepositoryWrapper extends AbstractLevelGetRequest {
    private final LevelGetRepository levelGetRepository;

    @Transactional
    public LevelGet findOneWithNotFoundDetection(final Integer id) {
        return this.levelGetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("LevelGet Not found " + id));
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
