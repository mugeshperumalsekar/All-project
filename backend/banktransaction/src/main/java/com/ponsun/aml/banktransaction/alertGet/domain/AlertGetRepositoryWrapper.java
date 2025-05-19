package com.ponsun.aml.banktransaction.alertGet.domain;


import com.ponsun.aml.banktransaction.alertGet.request.AbstractAlertGetRequest;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AlertGetRepositoryWrapper extends AbstractAlertGetRequest {
    private final AlertGetRepository alertGetRepository;

    @Transactional
    public AlertGet findOneWithNotFoundDetection(final Integer id) {
        return this.alertGetRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("AlertGet Not found " + id));
    }

    @Override
    public String toString() {
        return super.toString();
    }

}
