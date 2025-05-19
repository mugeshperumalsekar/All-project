package com.ponsun.aml.amlTeam.AmlComplaintReply.rowmapper;

import com.ponsun.aml.amlTeam.AmlComplaintReply.data.AmlComplaintReplyData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class AmlComplaintReplyRowMapper implements RowMapper<AmlComplaintReplyData> {
    private final String schema;

    public AmlComplaintReplyRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM aml_complaint_reply acr ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("acr.id as id");
        builder.append("acr.uid as uid");
        builder.append("acr.complaintAlertId as complaintAlertId");
        builder.append("acr.reply as reply");
        builder.append("acr.complaintId as complaintId");
        builder.append("acr.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public AmlComplaintReplyData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer uid = rs.getInt("uid");
        final Integer complaintAlertId = rs.getInt("complaintAlertId");
        final String reply = rs.getString("reply");
        final Integer  complaintId = rs.getInt("complaintId");
        final Integer euid= rs.getInt("  euid");
        return new AmlComplaintReplyData(id, uid,complaintAlertId,reply, complaintId,euid);

    }
}