package com.ponsun.aml.scamTeam.ScamStatus.services;

import com.ponsun.aml.scamTeam.ScamStatus.domain.ScamStatus;
import com.ponsun.aml.scamTeam.ScamStatus.domain.ScamStatusRepository;
import com.ponsun.aml.scamTeam.ScamStatus.domain.ScamStatusWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class ScamStatusReadServiceImpl implements ScamStatusReadService {
    private final ScamStatusWrapper scamStatusWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final ScamStatusRepository scamStatusRepository;

    @Override
    public ScamStatus fetchStatusById(Integer id){

        return this.scamStatusRepository.findById(id).get();
    }
    @Override
    public List<ScamStatus> fetchAllStatus(){return this.scamStatusRepository.findAll();}
}
