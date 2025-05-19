package com.ponsun.aml.amlTeam.AmlComplaintReply.rowmapper;
import com.ponsun.aml.amlTeam.AmlComplaintReply.data.AmlPendingResponseData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class AmlPendingResponseRowMapper implements RowMapper<AmlPendingResponseData> {
    private final String schema;

    public AmlPendingResponseRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM `aml_complaint_team` a,`aml_complaint_alert_scenarios` b," +
                "`aml_complaint_reply` c,`aml_config_branch` d,`aml_config_status` e ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id AS id,a.`targetCustomerName` AS targetCustomerName,a.`clientId` AS clientId ,a.`accountNumber` AS accountNumber ,a.`ticketId` AS ticketId ,d.`name` AS branchName,d.`branchCode`,e.name AS ticketStatus");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public AmlPendingResponseData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String targetCustomerName = rs.getString("targetCustomerName");
        final String clientId = rs.getString("clientId");
        final String accountNumber = rs.getString("accountNumber");
        final Integer ticketId = rs.getInt("ticketId");
        final String branchName = rs.getString("branchName");
        final String branchCode = rs.getString("branchCode");
        final String ticketStatus = rs.getString("ticketStatus");
        return new AmlPendingResponseData(id,targetCustomerName,clientId,accountNumber,ticketId,branchName,branchCode,ticketStatus);

    }
}