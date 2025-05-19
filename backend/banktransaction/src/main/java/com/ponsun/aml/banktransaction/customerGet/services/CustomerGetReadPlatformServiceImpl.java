package com.ponsun.aml.banktransaction.customerGet.services;

import com.ponsun.aml.banktransaction.customerGet.data.CustomerGetData;
import com.ponsun.aml.banktransaction.customerGet.rowmapper.CustomerGetRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class CustomerGetReadPlatformServiceImpl implements CustomerGetReadPlatformService {

    private final CustomerGetRowMapper customerGetRowMapper;
    private final JdbcTemplate jdbcTemplate;

    @Override
    public List<CustomerGetData> fetchAllTransactionGetData() {
        String query = "SELECT id,isCumulativeEntry,pocId,assign_investigation, transModeId, dt, transCount, TransCumulativeAmt, CustomerId, AccountId, " +
                "alert_details(transModeId, transCount, TransCumulativeAmt,isCumulativeEntry) AS alert_details, " +
                "customer_details(transModeId, CustomerId) AS customer_details FROM bank_alert a";
        return jdbcTemplate.query(query, customerGetRowMapper);
    }

}