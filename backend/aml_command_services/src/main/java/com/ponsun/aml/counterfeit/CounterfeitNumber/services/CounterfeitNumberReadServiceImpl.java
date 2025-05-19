package com.ponsun.aml.counterfeit.CounterfeitNumber.services;

import com.ponsun.aml.counterfeit.CounterfeitNumber.domain.CounterfeitNumber;
import com.ponsun.aml.counterfeit.CounterfeitNumber.domain.CounterfeitNumberRepository;
import com.ponsun.aml.counterfeit.CounterfeitNumber.domain.CounterfeitNumberWrapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class CounterfeitNumberReadServiceImpl implements CounterfeitNumberReadService {
    private final CounterfeitNumberWrapper CounterfeitNumberWrapperTeam;
    private final JdbcTemplate jdbcTemplate;
    private final CounterfeitNumberRepository CounterfeitNumberRepository;
    @Override
    public CounterfeitNumber fetchCounterfeitNumberById(Integer id){
        return this.CounterfeitNumberRepository.findById(id).get();
    }
    @Override
    public List<CounterfeitNumber> fetchAllCounterfeitNumber(){
        return this.CounterfeitNumberRepository.findAll();
    }
}