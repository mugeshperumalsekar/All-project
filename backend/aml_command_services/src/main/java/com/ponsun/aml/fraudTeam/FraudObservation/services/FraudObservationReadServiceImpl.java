package com.ponsun.aml.fraudTeam.FraudObservation.services;

import com.ponsun.aml.fraudTeam.FraudObservation.domain.FraudObservation;
import com.ponsun.aml.fraudTeam.FraudObservation.domain.FraudObservationRepository;
import com.ponsun.aml.fraudTeam.FraudObservation.domain.FraudObservationWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class FraudObservationReadServiceImpl implements FraudObservationReadService {
    private final FraudObservationWrapper fraudObservationWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final FraudObservationRepository fraudObservationRepository;
    @Override
    public FraudObservation fetchFraudObservationById(Integer id){
        return this.fraudObservationRepository.findById(id).get();
    }
    @Override
    public List<FraudObservation> fetchAllFraudObservation(){return this.fraudObservationRepository.findAll();}
}
