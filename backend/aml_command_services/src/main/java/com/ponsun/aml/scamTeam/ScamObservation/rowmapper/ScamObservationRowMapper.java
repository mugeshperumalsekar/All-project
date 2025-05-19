package com.ponsun.aml.scamTeam.ScamObservation.rowmapper;

import com.ponsun.aml.scamTeam.ScamObservation.data.ScamObservationData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class ScamObservationRowMapper implements RowMapper <ScamObservationData> {
    private final String schema;

    public ScamObservationRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM scam_observation so ");
        this.schema = builder.toString();
    }
    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("so.id as id, ");
        builder.append("so.scamId as scamId, ");
        builder.append("so.observation as observation, ");
        builder.append("so.ticketId as ticketId, ");
        builder.append("so.branchId as branchId, ");
        builder.append("so.ticketStatus as ticketStatus, ");
        builder.append("so.uid as uid, ");
        builder.append("so.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
   @Override
   public ScamObservationData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer scamId = rs.getInt("scamId");
        final String observation = rs.getString("observation");
        final Integer ticketId = rs.getInt("ticketId");
        final Integer branchId = rs.getInt("branchId");
        final String ticketStatus = rs.getString("ticketStatus");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new ScamObservationData(id,scamId,observation,ticketId,branchId,ticketStatus,uid,euid);
   }
}
