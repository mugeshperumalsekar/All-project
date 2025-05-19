package com.ponsun.aml.scamTeam.ScamRemark.rowmapper;

import com.ponsun.aml.scamTeam.ScamRemark.data.ScamRemarkData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.RowMapper;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class ScamRemarkRowMapper implements RowMapper <ScamRemarkData> {
    private final String schema;

    public ScamRemarkRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM scam_remark sr ");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("sr.id as id, ");
        builder.append("sr.scamId as scamId, ");
        builder.append("sr.branchId as branchId, ");
        builder.append("sr.ticketId as ticketId, ");
        builder.append("sr.remark as remark, ");
        builder.append("sr.uid as uid, ");
        builder.append("sr.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public ScamRemarkData mapRow(ResultSet rs, int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final Integer scamId = rs.getInt("scamId");
        final Integer branchId = rs.getInt("branchId");
        final Integer ticketId = rs.getInt("ticketId");
        final String remark = rs.getString("remark");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new ScamRemarkData(id,scamId,branchId,ticketId,remark,uid,euid);
    }
}
