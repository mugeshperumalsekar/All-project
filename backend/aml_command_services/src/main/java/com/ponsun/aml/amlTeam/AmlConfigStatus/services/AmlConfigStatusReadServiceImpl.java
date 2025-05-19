package com.ponsun.aml.amlTeam.AmlConfigStatus.services;

import com.ponsun.aml.amlTeam.AmlConfigStatus.domain.AmlConfigStatus;
import com.ponsun.aml.amlTeam.AmlConfigStatus.domain.AmlConfigStatusRepository;
import com.ponsun.aml.amlTeam.AmlConfigStatus.domain.AmlConfigStatusWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class AmlConfigStatusReadServiceImpl implements  AmlConfigStatusReadService{
    private final AmlConfigStatusWrapper amlConfigStatusWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final AmlConfigStatusRepository amlConfigStatusRepository;

    @Override
    public AmlConfigStatus fetchAmlConfigStatusById(Integer id){
        return this.amlConfigStatusRepository.findById(id).get();
    }
    @Override
    public List<AmlConfigStatus> fetchAllAmlConfigStatus(){return  this.amlConfigStatusRepository.findAll();}
}
