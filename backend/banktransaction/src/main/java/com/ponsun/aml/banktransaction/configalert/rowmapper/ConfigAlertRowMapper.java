package com.ponsun.aml.banktransaction.configalert.rowmapper;



import com.ponsun.aml.banktransaction.configalert.data.ConfigAlertData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
@Data
@Service
@Slf4j
public class ConfigAlertRowMapper implements RowMapper<ConfigAlertData> {
    private final String schema;
    public ConfigAlertRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM bank_config_alert configAlert ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("alert.id as id, ");
        builder.append("alert.days as days, ");
        builder.append("alert.minimumAmt as minimumAmt, ");
        builder.append("alert.aggregateAmt as aggregateAmt ");
        builder.append("alert.mode as mode ");
        builder.append("alert.transCount as transCount ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public ConfigAlertData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer days = rs.getInt("days");
        final Double  minimumAmt = rs.getDouble("minimumAmt");
        final Double  aggregateAmt = rs.getDouble("aggregateAmt");
        final String  mode = rs.getString("mode");
        final Integer  transCount = rs.getInt("transCount");
        return new ConfigAlertData(id,days,minimumAmt,aggregateAmt,mode,transCount);
    }
}
