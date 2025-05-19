package com.ponsun.aml.banktransaction.AuditLog.rowmapper;



import com.ponsun.aml.banktransaction.AuditLog.data.AuditLogData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j

public class AuditLogRowMapper implements RowMapper<AuditLogData> {
    private final String schema;
    public AuditLogRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM bank_audit_log bal ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("pcp.id as id,");
        builder.append("bal.levelId as levelId,");
        builder.append("bal.customerId as customerId,");
        builder.append("bal.alertId as alertId,");
        builder.append("bal.name as name");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public AuditLogData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer levelId = rs.getInt("levelId");
        final String customerId = rs.getString("customerId");
        final Integer alertId = rs.getInt("alertId");
        final String name = rs.getString("name");
        return new AuditLogData(id, levelId, customerId,alertId , name);
    }
}
