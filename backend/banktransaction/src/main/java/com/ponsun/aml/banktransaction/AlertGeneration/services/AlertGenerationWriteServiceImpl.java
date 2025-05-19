package com.ponsun.aml.banktransaction.AlertGeneration.services;

import com.ponsun.aml.banktransaction.AlertGeneration.domain.AlertGenerationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class AlertGenerationWriteServiceImpl implements AlertGenerationWriteService {
    private final AlertGenerationRepository alertGenerationRepository;

//    public AlertGenerationWriteServiceImpl(AlertGenerationRepository alertGenerationRepository) {
//        this.alertGenerationRepository = alertGenerationRepository;
//    }

    @Override
    @Transactional
    public void generateAlerts() {
        alertGenerationRepository.SP_AlertGeneration();
    }
}
