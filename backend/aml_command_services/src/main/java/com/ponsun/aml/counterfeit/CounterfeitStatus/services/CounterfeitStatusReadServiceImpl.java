package com.ponsun.aml.counterfeit.CounterfeitStatus.services;

import com.ponsun.aml.counterfeit.CounterfeitStatus.domain.CounterfeitStatus;
import com.ponsun.aml.counterfeit.CounterfeitStatus.domain.CounterfeitStatusRepository;
import com.ponsun.aml.counterfeit.CounterfeitStatus.domain.CounterfeitStatusWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j

public class CounterfeitStatusReadServiceImpl implements CounterfeitStatusReadService {
    private final CounterfeitStatusWrapper counterfeitStatusWrapperTeam;
    private final JdbcTemplate jdbcTemplate;
    private final CounterfeitStatusRepository counterfeitStatusRepository;
    @Override
    public CounterfeitStatus fetchCounterfeitStatusById(Integer id) {
        return this.counterfeitStatusRepository.findById(id).get();
    }
    @Override
    public List<CounterfeitStatus> fetchAllCounterfeitStatus(){
        return this.counterfeitStatusRepository.findAll();
    }
}