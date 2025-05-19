package com.ponsun.aml.banktransaction.transactionGet.services;

import com.ponsun.aml.banktransaction.transactionGet.data.TransactionGetData;
import com.ponsun.aml.banktransaction.transactionGet.rowmapper.TransactionGetRowMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
@RequiredArgsConstructor
@Slf4j
public class TransactionGetReadPlatformServiceImpl implements TransactionGetReadPlatformService{
    private final TransactionGetRowMapper transactionGetRowMapper;
    private final JdbcTemplate jdbcTemplate;
    @Override
    public List<TransactionGetData> getTransactionDetails(String senderCustomer) {
        final TransactionGetRowMapper rowMapper = new TransactionGetRowMapper();
        String Qry = "SELECT " + rowMapper.tableSchema();
        String whereClause = " WHERE senderCustomer = ?";
        Qry = Qry + whereClause;
        final List<TransactionGetData> transactionGetData = jdbcTemplate.query(Qry, transactionGetRowMapper,
                new Object[]{senderCustomer}
        );
        return transactionGetData;
    }
}
