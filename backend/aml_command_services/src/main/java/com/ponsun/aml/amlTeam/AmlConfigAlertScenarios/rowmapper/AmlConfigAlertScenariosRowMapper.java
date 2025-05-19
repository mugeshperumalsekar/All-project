package com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.rowmapper;

import com.ponsun.aml.amlTeam.AmlConfigAlertScenarios.data.AmlConfigAlertScenariosData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class AmlConfigAlertScenariosRowMapper implements RowMapper<AmlConfigAlertScenariosData> {
    private final String schema;

    public AmlConfigAlertScenariosRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM aml_config_alert_scenarios acas ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("acas.id as id");
        builder.append("acas alertScenarios as alertScenarios");
        builder.append("acas.uid as uid");
        builder.append("acas .euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public AmlConfigAlertScenariosData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String alertScenarios = rs.getNString("alertScenarios");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new AmlConfigAlertScenariosData(id, alertScenarios, uid, euid);
    }

    }
