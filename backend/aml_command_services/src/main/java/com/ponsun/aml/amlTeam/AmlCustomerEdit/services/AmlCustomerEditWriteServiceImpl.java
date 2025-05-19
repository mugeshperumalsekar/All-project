package com.ponsun.aml.amlTeam.AmlCustomerEdit.services;

import com.ponsun.aml.amlTeam.AmlCustomerEdit.data.AmlCustomerEditData;
import com.ponsun.aml.amlTeam.AmlCustomerEdit.rowmapper.AmlCustomerEditRowMapper;
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
public class AmlCustomerEditWriteServiceImpl implements AmlCustomerEditWriteService{
    private final JdbcTemplate jdbcTemplate;
    private final AmlCustomerEditRowMapper customerEditRowMapper;

    @Override
    public List<AmlCustomerEditData> fetchAllCustomerEditData(String frmDate, String toDate) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("frmDate", frmDate);
        parameters.put("toDate", toDate);
        final AmlCustomerEditRowMapper rowMapper = new AmlCustomerEditRowMapper();
        String Qry = "SELECT "  + rowMapper.tableSchema();
        String whereClause = " WHERE a.uid = b.id AND DATE(a.created_at) BETWEEN ? AND ? AND a.status='A' ";
        Qry = Qry + whereClause;
        final List<AmlCustomerEditData> customerEditData = jdbcTemplate.query(Qry,customerEditRowMapper,
                new Object[] {frmDate , toDate}
        );
        return customerEditData;
    }

}
