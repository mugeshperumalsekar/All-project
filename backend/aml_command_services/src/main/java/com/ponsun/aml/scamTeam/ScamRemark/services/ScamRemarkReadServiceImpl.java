package com.ponsun.aml.scamTeam.ScamRemark.services;

import com.ponsun.aml.scamTeam.ScamRemark.domain.ScamRemark;
import com.ponsun.aml.scamTeam.ScamRemark.domain.ScamRemarkRepository;
import com.ponsun.aml.scamTeam.ScamRemark.domain.ScamRemarkWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ScamRemarkReadServiceImpl implements ScamRemarkReadService {
    private final ScamRemarkWrapper scamRemarkWrapper;
    private final JdbcTemplate jdbcTemplate;
    private final ScamRemarkRepository scamRemarkRepository;

    @Override
    public ScamRemark fetchRemarkById(Integer id){

        return this.scamRemarkRepository.findById(id).get();
    }
    @Override
    public List<ScamRemark> fetchAllRemark(){return this.scamRemarkRepository.findAll();}
}
