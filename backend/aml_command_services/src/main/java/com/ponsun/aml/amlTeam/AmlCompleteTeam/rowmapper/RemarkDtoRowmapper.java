package com.ponsun.aml.amlTeam.AmlCompleteTeam.rowmapper;

import com.ponsun.aml.amlTeam.AmlCompleteTeam.data.RemarkDto;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class RemarkDtoRowmapper implements RowMapper<RemarkDto> {
    private final String schema;

    public RemarkDtoRowmapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM `aml_complaint_remark` ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("remark AS remark");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public RemarkDto mapRow(ResultSet rs, int rowNum) throws SQLException {
        final String remark = rs.getNString("remark");

        return new RemarkDto(remark);

    }

}
