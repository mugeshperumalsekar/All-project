package com.ponsun.aml.fraudTeam.FraudTeam.rowmapper;

import com.ponsun.aml.fraudTeam.FraudTeam.data.FraudTeamData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class FraudTeamRowMapper implements RowMapper<FraudTeamData> {
    private final String schema;

    public FraudTeamRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM fraud_team ft ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("ft.id as id,");
        builder.append("ft.branchCode as branchCode, ");
        builder.append("ft.branchId as branchId, ");
        builder.append("ft.clientId as clientId, ");
        builder.append("ft.accountNumber as accountNumber, ");
        builder.append("ft.ticketId as ticketId, ");
        builder.append("ft.ticketStatus as ticketStatus, ");
        builder.append("ft.targetCustomerName as targetCustomerName, ");
        builder.append("ft.uid as uid, ");
        builder.append("ft.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public FraudTeamData mapRow(ResultSet rs, int rowNum) throws SQLException{
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
       return new FraudTeamData(id,branchCode,branchId,clientId,accountNumber,ticketId,ticketStatus,targetCustomerName,uid,euid);
    }
}
