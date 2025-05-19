package com.ponsun.aml.banktransaction.infrastructure.display;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.StringJoiner;

@Service
@RequiredArgsConstructor
public class DisplayNumber{
    private final JdbcTemplate jdbcTemplate;
    public String gethitRecordsDisplayNumber() {
        String sql = "SELECT CONCAT(DATE_FORMAT(CURRENT_DATE,'%y%m%d'),IFNULL(COUNT(id),0)+1) AS hitRecordDisplayNumber FROM crm_hitdata WHERE DATE(dt)=CURRENT_DATE()";

        List<String> list = jdbcTemplate.queryForList(sql, String.class);

        StringJoiner joiner = new StringJoiner(", ");
        for (String element : list) {
            joiner.add(element);
        }
        String result = joiner.toString();
        return result;
    }
}
