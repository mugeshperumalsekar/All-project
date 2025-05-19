package com.ponsun.aml.amlTeam.AmlCompleteTeam.rowmapper;

import com.ponsun.aml.amlTeam.AmlCompleteTeam.data.ComplaintDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class ComplaintDtoRowmapper implements RowMapper<ComplaintDto> {
    private final String schema;

    public ComplaintDtoRowmapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM aml_complaint_team a,`aml_config_branch` b ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id AS complaintId ,b.name AS branchName,b.`branchCode` AS branchCode,a.clientId AS clientId ,a.accountNumber AS accountNumber,a.targetCustomerName AS targetCustomerName");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public ComplaintDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer complaintId = rs.getInt("complaintId");
        final String branchName = rs.getString("branchName");
        final String branchCode = rs.getString("branchCode");
        final String clientId = rs.getString("clientId");
        final String accountNumber = rs.getString("accountNumber");
        final String targetCustomerName = rs.getString("targetCustomerName");
        return new ComplaintDto(complaintId,branchName,branchCode,clientId,accountNumber,targetCustomerName);

    }

}
