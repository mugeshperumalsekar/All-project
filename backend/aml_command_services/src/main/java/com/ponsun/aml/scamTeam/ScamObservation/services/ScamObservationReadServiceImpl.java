package com.ponsun.aml.scamTeam.ScamObservation.services;

import com.ponsun.aml.scamTeam.ScamObservation.domain.ScamObservation;
import com.ponsun.aml.scamTeam.ScamObservation.domain.ScamObservationRepository;
import com.ponsun.aml.scamTeam.ScamObservation.domain.ScamObservationWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScamObservationReadServiceImpl implements ScamObservationReadService {
    private final ScamObservationWrapper scamObservationWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final ScamObservationRepository scamObservationRepository;
    @Override
    public ScamObservation fetchScamObservationById(Integer id){
        return this.scamObservationRepository.findById(id).get();
    }
    @Override
    public List<ScamObservation> fetchAllScamObservation(){return this.scamObservationRepository.findAll();}
}
