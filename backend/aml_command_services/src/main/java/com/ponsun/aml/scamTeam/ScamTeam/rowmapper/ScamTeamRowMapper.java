package com.ponsun.aml.scamTeam.ScamTeam.rowmapper;

import com.ponsun.aml.scamTeam.ScamTeam.data.ScamTeamData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class ScamTeamRowMapper implements RowMapper<ScamTeamData> {
    private final String schema;

    public ScamTeamRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM scam_team st ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("st.id as id,");
        builder.append("st.branchCode as branchCode, ");
        builder.append("st.branchId as branchId, ");
        builder.append("st.clientId as clientId, ");
        builder.append("st.accountNumber as accountNumber, ");
        builder.append("st.ticketId as ticketId, ");
        builder.append("st.ticketStatus as ticketStatus, ");
        builder.append("st.targetCustomerName as targetCustomerName, ");
        builder.append("st.uid as uid, ");
        builder.append("st.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public ScamTeamData mapRow(ResultSet rs, int rowNum) throws SQLException{
       final Integer id = rs.getInt("id");
       final String branchCode = rs.getString("branchCode");
       final Integer branchId = rs.getInt("branchId");
       final String clientId = rs.getString("clientId");
       final String accountNumber = rs.getString("accountNumber");
       final Integer ticketId = rs.getInt("ticketId");
       final String ticketStatus = rs.getString("ticketStatus");
       final String targetCustomerName = rs.getString("targetCustomerName");
       final Integer uid = rs.getInt("uid");
       final Integer euid = rs.getInt("euid");
       return new ScamTeamData(id,branchCode,branchId,clientId,accountNumber,ticketId,ticketStatus,targetCustomerName,uid,euid);
    }
}
