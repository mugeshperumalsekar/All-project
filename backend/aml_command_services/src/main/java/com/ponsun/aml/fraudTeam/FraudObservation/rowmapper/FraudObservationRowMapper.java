package com.ponsun.aml.fraudTeam.FraudObservation.rowmapper;

import com.ponsun.aml.fraudTeam.FraudObservation.data.FraudObservationData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class FraudObservationRowMapper implements RowMapper <FraudObservationData> {
    private final String schema;

    public FraudObservationRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM fraud_observation fo ");
        this.schema = builder.toString();
    }
    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" fo.id as id, ");
        builder.append(" fo.fraudId as fraudId, ");
        builder.append(" fo.observation as observation, ");
        builder.append(" fo.ticketId as ticketId, ");
        builder.append(" fo.branchId as branchId, ");
        builder.append(" fo.ticketStatus as ticketStatus, ");
        builder.append(" fo.uid as uid, ");
        builder.append(" fo.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
   @Override
   public FraudObservationData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer fraudId = rs.getInt("fraudId");
        final String observation = rs.getString("observation");
        final Integer ticketId = rs.getInt("ticketId");
        final Integer branchId = rs.getInt("branchId");
        final String ticketStatus = rs.getString("ticketStatus");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new FraudObservationData(id,fraudId,observation,ticketId,branchId,ticketStatus,uid,euid);
   }
}
