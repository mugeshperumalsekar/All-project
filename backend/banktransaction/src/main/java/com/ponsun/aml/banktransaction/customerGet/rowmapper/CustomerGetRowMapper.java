package com.ponsun.aml.banktransaction.customerGet.rowmapper;

import com.ponsun.aml.banktransaction.customerGet.data.CustomerGetData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
@Data
@Service
@Slf4j
public class CustomerGetRowMapper implements RowMapper<CustomerGetData> {
    @Override
    public CustomerGetData mapRow(ResultSet rs, int rowNum) throws SQLException {
        Integer id = rs.getInt("id");
        Integer transModeId = rs.getInt("transModeId");
        Integer transCount = rs.getInt("transCount");
        Double transCumulativeAmt = rs.getDouble("TransCumulativeAmt");
        String customerId = rs.getString("CustomerId");
        String accountId = rs.getString("AccountId");
        String alertDetails = rs.getString("alert_details");
        LocalDateTime dt = rs.getTimestamp("dt").toLocalDateTime();
        Integer assignInvestigation = rs.getInt("assign_investigation");
        String[] alertDetailsSplit = alertDetails.split("<#>");
        String txnAlert = "";
        String description = "";
            if (alertDetailsSplit.length >= 2) {
                txnAlert = alertDetailsSplit[0];
                description = alertDetailsSplit[1];
            }
        String customerDetails = rs.getString("customer_details");
        String[] customerDetailsSplit = customerDetails.split("<#>");
        String customerName = "";
        String accountNum = "";
        String bankName = "";
        String branchName = "";
            if (customerDetailsSplit.length >= 4) {
                customerName = customerDetailsSplit[0];
                accountNum = customerDetailsSplit[1];
                bankName = customerDetailsSplit[2];
                branchName = customerDetailsSplit[3];
            }
        Integer pocId = rs.getInt("pocId");
        Integer isCumulativeEntry = rs.getInt("isCumulativeEntry");
        return new CustomerGetData(id,transModeId , transCount, transCumulativeAmt,
                customerId, accountId, alertDetails, dt, assignInvestigation,
                txnAlert, description, customerName, accountNum, bankName, branchName,pocId,isCumulativeEntry);
    }
}
