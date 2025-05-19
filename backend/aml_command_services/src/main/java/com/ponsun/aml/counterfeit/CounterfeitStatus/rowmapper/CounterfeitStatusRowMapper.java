package com.ponsun.aml.counterfeit.CounterfeitStatus.rowmapper;


import com.ponsun.aml.counterfeit.CounterfeitStatus.data.CounterfeitStatusData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class CounterfeitStatusRowMapper implements RowMapper<CounterfeitStatusData> {

    private final String schema;
    public CounterfeitStatusRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM counterfeit_status cs ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" cs.id as id,");
        builder.append(" cs.counterfeitId as counterfeitId,");
        builder.append(" cs.branchCode as branchCode,");
        builder.append(" cs.branchId as branchId,");
        builder.append(" cs.counterfeitStatus as counterfeitStatus,");
        builder.append(" cs.ticketId as ticketId,");
        builder.append(" cs.ticketStatus as ticketStatus,");
        builder.append(" cs.uid as uid,");
        builder.append(" cs.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public CounterfeitStatusData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer counterfeitId = rs.getInt("counterfeitId");
        final String branchCode = rs.getString("branchCode");
        final Integer branchId = rs.getInt("branchId");
        final String counterfeitStatus = rs.getString("counterfeitStatus");
        final String ticketStatus = rs.getString("ticketStatus");
        final Integer ticketId = rs.getInt("ticketId");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new CounterfeitStatusData(id, counterfeitId,branchCode,branchId,counterfeitStatus,ticketStatus,ticketId,uid,euid);

    }
}