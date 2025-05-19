package com.ponsun.aml.counterfeit.CounterfeitRemark.services;

import com.ponsun.aml.counterfeit.CounterfeitRemark.domain.CounterfeitRemark;
import com.ponsun.aml.counterfeit.CounterfeitRemark.domain.CounterfeitRemarkRepository;
import com.ponsun.aml.counterfeit.CounterfeitRemark.domain.CounterfeitRemarkWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CounterfeitRemarkReadServiceImpl implements CounterfeitRemarkReadService {
    private final CounterfeitRemarkWrapper counterfeitRemarkWrapperTeam;
    private final JdbcTemplate jdbcTemplate;
    private final CounterfeitRemarkRepository counterfeitRemarkRepository;
    @Override
    public CounterfeitRemark fetchCounterfeitRemarkById(Integer id){
        return this.counterfeitRemarkRepository.findById(id).get();
    }
    @Override
    public List<CounterfeitRemark> fetchAllCounterfeitRemark(){
        return this.counterfeitRemarkRepository.findAll();
    }
}