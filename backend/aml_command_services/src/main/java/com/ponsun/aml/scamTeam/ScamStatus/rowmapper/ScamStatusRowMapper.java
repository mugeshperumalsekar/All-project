package com.ponsun.aml.scamTeam.ScamStatus.rowmapper;

import com.ponsun.aml.scamTeam.ScamStatus.data.ScamStatusData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class ScamStatusRowMapper implements RowMapper<ScamStatusData> {
    private final String schema;

    public ScamStatusRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM scam_status ss ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("ss.id as id , ");
        builder.append("ss.scamId as scamId , ");
        builder.append("ss.branchCode as branchCode , ");
        builder.append("ss.branchId as branchId , ");
        builder.append("ss.scamStatus as scamStatus  ,");
        builder.append("ss.ticketId as ticketId , ");
        builder.append("ss.ticketStatus as ticketStatus , ");
        builder.append("ss.uid as uid , ");
        builder.append("ss.euid as euid  ");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public ScamStatusData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer scamId = rs.getInt("scamId");
        final String branchCode = rs.getString("branchCode");
        final Integer branchId = rs.getInt("branchId");
        final String scamStatus = rs.getString("scamStatus");
        final Integer ticketId = rs.getInt("ticketId");
        final String ticketStatus = rs.getString("ticketStatus");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new ScamStatusData(id,scamId,branchCode,branchId,scamStatus,ticketId,ticketStatus,uid,euid);
    }
}
