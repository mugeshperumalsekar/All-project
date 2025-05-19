package com.ponsun.aml.amlTeam.BranchUserMapping.rowmapper;
import com.ponsun.aml.amlTeam.BranchUserMapping.data.BranchUserMappingData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class BranchUserMappingRowMapper implements RowMapper<BranchUserMappingData> {
    private final String schema;

    public BranchUserMappingRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM branch_user_mapping buma ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("buma.id as id");
        builder.append("buma.branchId as branchId");
        builder.append("buma.userId as userId");
        builder.append("buma.entryDate as entryDate");
        builder.append("buma.uid as uid");
        builder.append("buma.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public BranchUserMappingData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final Integer branchId = rs.getInt("branchId");
        final String userId = rs.getString("userId");
        final String entryDate = rs.getString("entryDate");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new BranchUserMappingData(id, branchId, userId, entryDate, uid, euid);

    }
}