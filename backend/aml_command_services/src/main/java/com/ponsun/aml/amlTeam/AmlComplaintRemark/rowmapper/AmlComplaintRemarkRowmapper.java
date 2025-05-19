package com.ponsun.aml.amlTeam.AmlComplaintRemark.rowmapper;

import com.ponsun.aml.amlTeam.AmlComplaintRemark.data.AmlComplaintRemarkData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class AmlComplaintRemarkRowmapper implements RowMapper<AmlComplaintRemarkData> {
    private final String schema;

    public AmlComplaintRemarkRowmapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM aml_complaint_remark acre ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
//        builder.append("acre.id as id");
        builder.append("acre.uid as uid");
        builder.append("acre.remark as remark");
        builder.append("acre.complaintId as complaintId");
        builder.append("acre.branchId as branchId");
        builder.append("acre.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public AmlComplaintRemarkData mapRow(ResultSet rs, int rowNum) throws SQLException {
//        final Integer id = rs.getInt("id");
        final Integer uid = rs.getInt("uid");
        final String remark = rs.getNString("remark");
        final Integer complaintId = rs.getInt("complaintId");
        final Integer branchId = rs.getInt("branchId");
        final Integer euid= rs.getInt("  euid");

        return new AmlComplaintRemarkData(uid,remark,complaintId,branchId,euid);

    }
}
