package com.ponsun.aml.fraudTeam.FraudRemark.rowmapper;

import com.ponsun.aml.fraudTeam.FraudRemark.data.FraudRemarkData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class FraudRemarkRowMapper implements RowMapper <FraudRemarkData> {
    private final String schema;

    public FraudRemarkRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM fraud_remark fr ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("fr.id as id, ");
        builder.append("fr.fraudId as fraudId, ");
        builder.append("fr.branchId as branchId, ");
        builder.append("fr.ticketId as ticketId, ");
        builder.append("fr.remark as remark, ");
        builder.append("fr.uid as uid, ");
        builder.append("fr.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public FraudRemarkData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer fraudId = rs.getInt("fraudId");
        final Integer branchId = rs.getInt("branchId");
        final Integer ticketId = rs.getInt("ticketId");
        final String remark = rs.getString("remark");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new FraudRemarkData(id,fraudId,branchId,ticketId,remark,uid,euid);
    }
}
