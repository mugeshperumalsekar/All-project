package com.ponsun.aml.amlTeam.AmlCustomerEdit.rowmapper;
import com.ponsun.aml.amlTeam.AmlCustomerEdit.data.AmlCustomerEditData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class AmlCustomerEditRowMapper implements RowMapper<AmlCustomerEditData> {
    private final String schema;

    public AmlCustomerEditRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM aml_complaint_team a , admin_users b  ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" a.id AS complaintId , a.targetCustomerName AS targetCustomerName , a.ticketId AS ticketId ,b.full_name AS userName, DATE(a.created_at) AS created_at ,a.uid AS uid");
        builder.append(this.schema);
        return builder.toString();
    }


    @Override
    public AmlCustomerEditData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer complaintId = rs.getInt("complaintId");
        final String username = rs.getString("username");
        final String targetCustomerName = rs.getString("targetCustomerName");
        final String frmDate = "";   //rs.getString("frmDate");
        final String toDate = "";   //rs.getString("toDate");
        final Integer ticketId = rs.getInt("ticketId");
        final Integer uid = rs.getInt("uid");
        final String  created_at = rs.getString("created_at");
        return new AmlCustomerEditData( complaintId, username, targetCustomerName, frmDate, toDate, ticketId, uid,created_at);

    }
}