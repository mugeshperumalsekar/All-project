package com.ponsun.aml.amlTeam.AmlCustomerAllData.services;

import com.ponsun.aml.amlTeam.AmlCustomerAllData.data.AmlCustomerAllDataData;
import com.ponsun.aml.amlTeam.AmlCustomerAllData.rowmapper.AmlCustomerAllDataRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class AmlCustomerAllDataWriteServiceImpl implements AmlCustomerAllDataWriteService {
    private final JdbcTemplate jdbcTemplate;
    private final AmlCustomerAllDataRowMapper customerAllDataRowMapper;

    @Override
    public List<AmlCustomerAllDataData> fetchAllCustomerData() {
        Map<String, Object> parameters = new HashMap<>();
        final AmlCustomerAllDataRowMapper rowMapper = new AmlCustomerAllDataRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE a.uid=b.id AND a.status='A' ";
        Qry = Qry + whereClause;
        final List<AmlCustomerAllDataData> customerAllDataRowMappers = jdbcTemplate.query(Qry, customerAllDataRowMapper);
        return customerAllDataRowMappers;

    }
}