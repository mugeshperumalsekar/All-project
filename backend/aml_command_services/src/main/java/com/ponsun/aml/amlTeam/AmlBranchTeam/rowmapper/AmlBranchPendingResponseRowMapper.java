package com.ponsun.aml.amlTeam.AmlBranchTeam.rowmapper;
import com.ponsun.aml.amlTeam.AmlBranchTeam.data.AmlBranchPendingResponseData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;
import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class AmlBranchPendingResponseRowMapper implements RowMapper<AmlBranchPendingResponseData> {
    private final String schema;

    public AmlBranchPendingResponseRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM `aml_complaint_team` a,`aml_config_branch` d ");
        this.schema = builder.toString();
    }
    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("a.id ,a.`targetCustomerName`,a.`clientId`,a.`accountNumber`,a.`ticketId`,d.`name` AS branchName,d.`branchCode`");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public AmlBranchPendingResponseData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String targetCustomerName = rs.getString("targetCustomerName");
        final String clientId = rs.getString("clientId");
        final String accountNumber = rs.getString("accountNumber");
        final Integer ticketId = rs.getInt("ticketId");
        final String branchName = rs.getString("branchName");
        final String branchCode = rs.getString("branchCode");
        return new AmlBranchPendingResponseData(id, targetCustomerName, clientId, accountNumber, ticketId, branchName, branchCode);
    }

}
