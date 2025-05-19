package com.ponsun.aml.amlTeam.AmlComplaintStatus.rowmapper;

import com.ponsun.aml.amlTeam.AmlComplaintStatus.data.AmlComplaintStatusData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class AmlComplaintStatusRowMapper implements RowMapper<AmlComplaintStatusData> {
    private final String schema;

    public AmlComplaintStatusRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM aml_config_status acst ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("acst.id as id");
        builder.append("acst.uid as uid");
        builder.append("acst ticketId as ticketId");
        builder.append("acst. complaintId as complaintId");
        builder.append("acst.branchId as branchId");
        builder.append("acst.ticketStatusId as ticketStatusId");
        builder.append("acst.remark as remark");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public AmlComplaintStatusData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer uid = rs.getInt("uid");
        final Integer ticketId = rs.getInt("ticketId");
        final Integer complaintId = rs.getInt("complaintId");
        final Integer branchId = rs.getInt(   "branchId");
        final Integer ticketStatusId = rs.getInt("ticketStatusId");
        final String remark = rs.getString("remark");
        return new AmlComplaintStatusData(id,uid,ticketId,complaintId,branchId,ticketStatusId,remark);
    }
    }
