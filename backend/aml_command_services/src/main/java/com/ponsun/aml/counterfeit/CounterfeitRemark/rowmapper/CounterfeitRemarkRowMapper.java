package com.ponsun.aml.counterfeit.CounterfeitRemark.rowmapper;


import com.ponsun.aml.counterfeit.CounterfeitRemark.data.CounterfeitRemarkData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class CounterfeitRemarkRowMapper implements RowMapper<CounterfeitRemarkData> {
    private final String schema;

    public CounterfeitRemarkRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM counterfeit_remark cr ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" cr.id as id,");
        builder.append(" cr.counterfeitId as counterfeitId,");
        builder.append(" cr.branchId as branchId,");
        builder.append(" cr.ticketId as ticketId,");
        builder.append(" cr.remark as remark,");
        builder.append(" cr.uid as uid,");
        builder.append(" cr.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public CounterfeitRemarkData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer counterfeitId = rs.getInt("counterfeitId");
        final Integer branchId = rs.getInt("branchId");
        final Integer ticketId = rs.getInt("ticketId");
        final String remark = rs.getString("remark");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new CounterfeitRemarkData(id,counterfeitId,branchId,ticketId,remark,uid,euid);
    }
}