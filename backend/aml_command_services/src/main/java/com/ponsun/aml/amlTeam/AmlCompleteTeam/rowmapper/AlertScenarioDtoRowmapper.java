package com.ponsun.aml.amlTeam.AmlCompleteTeam.rowmapper;
import com.ponsun.aml.amlTeam.AmlCompleteTeam.data.AlertScenarioDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class AlertScenarioDtoRowmapper implements RowMapper<AlertScenarioDto> {
    private final String schema;

    public AlertScenarioDtoRowmapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM `aml_complaint_alert_scenarios` a,`aml_config_alert_scenarios` b ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id AS complaintAlertId,a.replyQry AS replyQry,b.alertScenarios AS alertScenarios");

        builder.append(this.schema);
        return builder.toString();

    }
//    complaintAlertId
//            replyQry
    @Override
    public AlertScenarioDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer complaintAlertId = rs.getInt("complaintAlertId");
        final String replyQry   = rs.getString("replyQry");
        final String alertScenarios = rs.getString("alertScenarios");

        return new AlertScenarioDto(complaintAlertId,replyQry,alertScenarios);

    }
}
