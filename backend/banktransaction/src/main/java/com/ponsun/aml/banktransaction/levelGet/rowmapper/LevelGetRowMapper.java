package com.ponsun.aml.banktransaction.levelGet.rowmapper;

import com.ponsun.aml.banktransaction.levelGet.data.LevelGetData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class LevelGetRowMapper implements RowMapper<LevelGetData> {

    private final String schema;

    public LevelGetRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM bank_level LevelGet ");
        this.schema = builder.toString();
    }

    public String schema() {
        return this.schema;
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("LevelGet.id as id, ");
        builder.append("LevelGet.name as name ");
        builder.append(this.schema);
        return builder.toString();
    }


    @Override
    public LevelGetData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        return LevelGetData.newInstance(id, name);
    }
}
