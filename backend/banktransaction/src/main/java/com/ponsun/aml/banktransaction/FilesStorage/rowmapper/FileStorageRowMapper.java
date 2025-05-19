package com.ponsun.aml.banktransaction.FilesStorage.rowmapper;

import com.ponsun.aml.banktransaction.FilesStorage.data.FileStorageData;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class FileStorageRowMapper implements RowMapper<FileStorageData> {


    private final String schema;

    public FileStorageRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM bank_document Bd");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("Bd.id as id");
        builder.append("bd.documentType as documentType");
        builder.append("Bd.customerId as customerId");
        builder.append("Bd.alertId as alertId");
        builder.append("Bd.documentType as documentType");
        builder.append("Bd.updated_at as dt");
        builder.append("Bd.url as url");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public FileStorageData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String documentType = rs.getString("documentType");
        final String customerId = rs.getString("customerId");
        final Integer alertId =rs.getInt("alertId");
        final String dt = rs.getString("dt");
        final String url =rs.getString("url");
        return new FileStorageData(id,documentType,customerId,alertId,dt,url);
    }
}
