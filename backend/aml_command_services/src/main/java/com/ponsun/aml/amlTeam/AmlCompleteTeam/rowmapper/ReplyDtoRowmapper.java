package com.ponsun.aml.amlTeam.AmlCompleteTeam.rowmapper;

import com.ponsun.aml.amlTeam.AmlCompleteTeam.data.ReplyDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class ReplyDtoRowmapper implements RowMapper<ReplyDto> {
    private final String schema;

    public ReplyDtoRowmapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM `aml_complaint_reply` ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("reply AS reply");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public ReplyDto mapRow(ResultSet rs, int rowNum) throws SQLException {

        final String reply = rs.getString("reply");
        return new ReplyDto(reply);

    }
}
