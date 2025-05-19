package com.ponsun.aml.banktransaction.alert.rowmapper;



import com.ponsun.aml.banktransaction.alert.data.AlertData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class AlertRowMapper implements RowMapper<AlertData> {
    private final String schema;
    public AlertRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM bank_alert alert ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("alert.id as id, ");
        builder.append("alert.customerId as customerId, ");
        builder.append("alert.bankAccount as bankAccount, ");
        builder.append("alert.alert as alert ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public AlertData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer customerId = rs.getInt("customerId");
        final String  bankAccount = rs.getString("bankAccount");
        final String  alert = rs.getString("alert");
        return new AlertData(id,customerId,bankAccount,alert);
    }
}
