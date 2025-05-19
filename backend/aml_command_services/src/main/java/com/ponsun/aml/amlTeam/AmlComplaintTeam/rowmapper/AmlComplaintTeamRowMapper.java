package com.ponsun.aml.amlTeam.AmlComplaintTeam.rowmapper;

import com.ponsun.aml.amlTeam.AmlComplaintTeam.data.AmlComplaintTeamData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class AmlComplaintTeamRowMapper implements RowMapper<AmlComplaintTeamData> {
    private final String schema;

    public AmlComplaintTeamRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM aml_complaint_team act ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("act.id as id");
        builder.append("act.ticketId as ticketId");
        builder.append("act.branchId as branchId");
        builder.append("act clientId as clientId");
        builder.append("act.accountNumber as accountNumber");
        builder.append("act .targetCustomerName as targetCustomerName");
        builder.append("act.uid as uid");
        builder.append("act.euid as euid");
        builder.append("act.ticketStatusId as ticketStatusId");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public AmlComplaintTeamData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer ticketId = rs.getInt("ticketId");
        final Integer branchId = rs.getInt("branchId");
        final String clientId = rs.getString("clientId");
        final String accountNumber = rs.getString("accountNumber");
        final String targetCustomerName = rs.getString("targetCustomerName");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        final Integer ticketStatusId = rs.getInt("ticketStatusId");

        return new AmlComplaintTeamData(id,ticketId,branchId,clientId,accountNumber,targetCustomerName,uid,euid,ticketStatusId);

    }
}
