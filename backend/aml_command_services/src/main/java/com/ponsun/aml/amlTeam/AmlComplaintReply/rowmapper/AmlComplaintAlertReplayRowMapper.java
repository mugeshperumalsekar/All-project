package com.ponsun.aml.amlTeam.AmlComplaintReply.rowmapper;

import com.ponsun.aml.amlTeam.AmlComplaintReply.data.AmlComplaintAlertReplayData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class AmlComplaintAlertReplayRowMapper implements RowMapper<AmlComplaintAlertReplayData> {
    private final String schema;

    public AmlComplaintAlertReplayRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM aml_complaint_alert_scenarios a,aml_complaint_reply b,aml_config_alert_scenarios c ");
        this.schema = builder.toString();
    }
    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id AS scenarioId,b.id AS complaintAlertId ,c.`alertScenarios` AS alertScenarios ,a.replyQry AS replyQry,b.`reply` AS reply");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public AmlComplaintAlertReplayData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer scenarioId = rs.getInt("scenarioId");
        final Integer complaintAlertId = rs.getInt("complaintAlertId");
        final String alertScenarios = rs.getString("alertScenarios");
        final String replyQry = rs.getString("replyQry");
        final String reply = rs.getString("reply");
        return new AmlComplaintAlertReplayData(scenarioId, complaintAlertId, alertScenarios, replyQry, reply);
    }
}