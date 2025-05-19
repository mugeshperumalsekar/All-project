package com.ponsun.aml.amlTeam.AmlConfigStatus.rowmapper;


import com.ponsun.aml.amlTeam.AmlConfigStatus.data.AmlConfigStatusData;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;

@Data
@Service
@Slf4j
public class AmlConfigStatusRowMapper implements RowMapper <AmlConfigStatusData> {
    private final String schema;

    private AmlConfigStatusRowMapper(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append(" FROM aml_config_status cs");
        this.schema = builder.toString();
    }
    public String tableSchema(){
        final StringBuilder builder = new StringBuilder(200);
        builder.append("cs.id as id ");
        builder.append("cs.name as name ");
        builder.append("cs.uid as uid ");
        builder.append("cs.euid as euid ");
        builder.append(this.schema);
        return builder.toString();
    }
    @Override
    public AmlConfigStatusData mapRow(ResultSet rs,int rowNum) throws SQLException{
        final Integer id = rs.getInt("id");
        final String name = rs.getString("name");
        final Integer uid = rs.getInt("uid");
        final Integer euid = rs.getInt("euid");
        return new AmlConfigStatusData(id,name,uid,euid);
    }
}
