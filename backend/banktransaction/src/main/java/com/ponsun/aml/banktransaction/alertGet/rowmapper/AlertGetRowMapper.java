package com.ponsun.aml.banktransaction.alertGet.rowmapper;

import com.ponsun.aml.banktransaction.alertGet.data.AlertGetData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class AlertGetRowMapper implements RowMapper<AlertGetData> {

    private final String schema;

    public AlertGetRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM bank_alert alert ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("alert.id as id, ");
        builder.append("alert.alert as alert, ");
        builder.append("alert.senderAccount as senderAccount, ");
        builder.append("alert.senderCustomerId as senderCustomerId, ");
        builder.append("alert.transCount as transCount, ");
        builder.append("alert.TransCumulativeAmt as TransCumulativeAmt, ");
        builder.append("alert.bankAccount as bankAccount ,");
        builder.append("alert.customerId as customerId ,");
        builder.append("alert.transModeId as transModeId ");
        builder.append(this.schema);
        return builder.toString();
    }


    @Override
    public AlertGetData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String alert = rs.getString("alert");
        final String senderAccount = rs.getString("senderAccount");
        final String senderCustomerId = rs.getString("senderCustomerId");
        final Integer transCount = rs.getInt("transCount");
        final Double TransCumulativeAmt = rs.getDouble("TransCumulativeAmt");
        final String bankAccount = rs.getString("bankAccount");
        final String customerId = rs.getString("customerId");
        final Integer transModeId = rs.getInt("transModeId");
        return new  AlertGetData(id, alert, senderAccount, senderCustomerId, transCount, TransCumulativeAmt, bankAccount, customerId, transModeId);
    }
}
