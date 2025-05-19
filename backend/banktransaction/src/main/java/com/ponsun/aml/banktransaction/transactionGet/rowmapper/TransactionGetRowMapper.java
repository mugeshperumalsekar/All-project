package com.ponsun.aml.banktransaction.transactionGet.rowmapper;


import com.ponsun.aml.banktransaction.transactionGet.data.TransactionGetData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;

@Data
@Service
@Slf4j

public class TransactionGetRowMapper implements RowMapper <TransactionGetData>{

    private final String schema;
    public TransactionGetRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM bank_transaction_details a  ");
        this.schema = builder.toString();
    }
    public String schema() {
        return this.schema;
    }

    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("'valliyur' AS branch , senderAccount AS senderAccount , withdrawals AS withdrawals , DATE(dt) AS dt , date ,country AS country , receiver AS receiver , receiverBankName AS receiverBankName,receiverCountry AS receiverCountry");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public  TransactionGetData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String branch = rs.getString("branch");
        final String senderAccount = rs.getString("senderAccount");
        final String withdrawals = rs.getString("withdrawals");
        final LocalDateTime dt = rs.getTimestamp("dt").toLocalDateTime();
        final LocalDateTime date = rs.getTimestamp("date").toLocalDateTime();
        final String country = rs.getString("country");
        final String receiver = rs.getString("receiver");
        final String receiverBankName = rs.getString("receiverBankName");
        final String receiverCountry =rs.getString("receiverCountry");
        return new TransactionGetData(branch,senderAccount, withdrawals, dt,date, country, receiver, receiverBankName, receiverCountry);
    }
}
