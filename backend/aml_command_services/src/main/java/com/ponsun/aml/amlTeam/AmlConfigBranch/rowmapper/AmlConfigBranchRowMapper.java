package com.ponsun.aml.amlTeam.AmlConfigBranch.rowmapper;
import com.ponsun.aml.amlTeam.AmlConfigBranch.data.AmlConfigBranchData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class AmlConfigBranchRowMapper implements RowMapper<AmlConfigBranchData> {
    private final String schema;

    public AmlConfigBranchRowMapper() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("FROM config_branch cobr ");
        this.schema = builder.toString();
    }

    public String tableSchema() {
        final StringBuilder builder = new StringBuilder(200);
        builder.append("cobr.id as id");
        builder.append("cobr.name as name");
        builder.append("cobr.branchCode as branchCode");
        builder.append("cobr.uid as uid");
        builder.append("cobr.euid as euid");
        builder.append(this.schema);
        return builder.toString();
    }

    @Override
    public AmlConfigBranchData mapRow(ResultSet rs, int rowNum) throws SQLException {
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        final String branchCode = rs.getString("branchCode");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new AmlConfigBranchData(id,name,branchCode,uid,euid);

    }
}