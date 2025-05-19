package com.ponsun.aml.counterfeit.CounterfeitTeam.romapper;

import com.ponsun.aml.counterfeit.CounterfeitTeam.data.CounterfeitTeamData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class CounterfeitTeamRowMapper implements RowMapper<CounterfeitTeamData> {
    private final String schema;

    public CounterfeitTeamRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM counterfeit_team ct ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" ct.id as id,");
        builder.append(" ct.ticketId as ticketId,");
        builder.append(" ct.branchCode as branchCode,");
        builder.append(" ct.clientId as clientId,");
        builder.append(" ct.accountNumber as accountNumber,");
        builder.append(" ct.targetCustomerName as targetCustomerName,");
        builder.append(" ct.uid as uid,");
        builder.append(" ct.euid as euid,");
        builder.append(" ct.ticketStatus as ticketStatus, ");
        builder.append(" ct.branchId as branchId ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public CounterfeitTeamData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer ticketId = rs.getInt("ticketId");
        final String branchCode = rs.getString("branchCode");
        final String clientId = rs.getString("clientId");
        final String accountNumber = rs.getNString("accountNumber");
        final String targetCustomerName = rs.getNString("targetCustomerName");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        final String ticketStatus = rs.getNString("ticketStatus");
        final Integer branchId = rs.getInt("branchId");
        return new CounterfeitTeamData(id,ticketId,branchCode,clientId,accountNumber,targetCustomerName,uid,euid,ticketStatus,branchId);

    }

}