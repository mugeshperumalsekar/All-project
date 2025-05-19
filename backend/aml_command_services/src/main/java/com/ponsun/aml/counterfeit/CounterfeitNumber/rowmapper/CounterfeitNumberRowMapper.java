package com.ponsun.aml.counterfeit.CounterfeitNumber.rowmapper;


import com.ponsun.aml.counterfeit.CounterfeitNumber.data.CounterfeitNumberData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class CounterfeitNumberRowMapper implements RowMapper<CounterfeitNumberData> {
    private final String schema;

    public CounterfeitNumberRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM counterfeit_number cn ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" cn.id as id,");
        builder.append(" cn.counterfeitId as counterfeitId,");
        builder.append(" cn.counterfeitNo as counterfeitNo,");
        builder.append(" cn.denomination as denomination,");
        builder.append(" cn.ticketId as ticketId,");
        builder.append(" cn.branchId as branchId,");
        builder.append(" cn.ticketStatus as ticketStatus,");
        builder.append(" cn.uid as uid,");
        builder.append(" cn.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public CounterfeitNumberData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer counterfeitId = rs.getInt("counterfeitId");
        final String counterfeitNo = rs.getString("counterfeitNo");
        final String denomination = rs.getString("denomination");
        final Integer ticketId = rs.getInt("ticketId");
        final Integer branchId = rs.getInt("branchId");
        final String ticketStatus = rs.getString("ticketStatus");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new CounterfeitNumberData(id,counterfeitId,counterfeitNo,denomination,ticketId,branchId,ticketStatus,uid,euid);
    }
}