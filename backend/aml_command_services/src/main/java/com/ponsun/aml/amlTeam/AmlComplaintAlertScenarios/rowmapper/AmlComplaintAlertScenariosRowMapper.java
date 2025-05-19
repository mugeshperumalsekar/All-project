package com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.rowmapper;

import com.ponsun.aml.amlTeam.AmlComplaintAlertScenarios.data.AmlComplaintAlertScenariosData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class AmlComplaintAlertScenariosRowMapper implements RowMapper<AmlComplaintAlertScenariosData> {
    private final String schema;

    public AmlComplaintAlertScenariosRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM aml_complaint_alert_scenarios acas ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("acas.id as id");
        builder.append("acas.complaintId as complaintId");
        builder.append("acas.scenarioId as scenarioId");
        builder.append("acas.replyQry as replyQry");
        builder.append("acas.euid as euid");
        builder.append("acas.uid as uid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public AmlComplaintAlertScenariosData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer complaintId = rs.getInt("complaintId");
        final Integer scenarioId = rs.getInt("scenarioId");
        final String replyQry = rs.getString("replyQry");
        final Integer euid = rs.getInt("euid");
        final Integer uid = rs.getInt("uid");
        return new AmlComplaintAlertScenariosData(id,complaintId,scenarioId,replyQry,euid,uid);

    }
}