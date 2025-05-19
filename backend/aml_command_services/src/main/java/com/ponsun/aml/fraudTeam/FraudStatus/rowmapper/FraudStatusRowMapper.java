package com.ponsun.aml.fraudTeam.FraudStatus.rowmapper;

import com.ponsun.aml.fraudTeam.FraudStatus.data.FraudStatusData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class FraudStatusRowMapper implements RowMapper<FraudStatusData> {
    private final String schema;

    public FraudStatusRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM fraud_status fs ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("fs.id as id , ");
        builder.append("fs.fraudId as fraudId , ");
        builder.append("fs.branchCode as branchCode , ");
        builder.append("fs.branchId as branchId , ");
        builder.append("fs.fraudStatus as fraudStatus  ,");
        builder.append("fs.ticketId as ticketId , ");
        builder.append("fs.ticketStatus as ticketStatus , ");
        builder.append("fs.uid as uid , ");
        builder.append("fs.euid as euid  ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public FraudStatusData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer fraudId = rs.getInt("fraudId");
        final String branchCode = rs.getString("branchCode");
        final Integer branchId = rs.getInt("branchId");
        final String fraudStatus = rs.getString("fraudStatus");
        final Integer ticketId = rs.getInt("ticketId");
        final String ticketStatus = rs.getString("ticketStatus");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new FraudStatusData(id,fraudId,branchCode,branchId,fraudStatus,ticketId,ticketStatus,uid,euid);
    }
}
