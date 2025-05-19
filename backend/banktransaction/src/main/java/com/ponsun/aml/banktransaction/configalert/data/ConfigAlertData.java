package com.ponsun.aml.banktransaction.configalert.data;

import lombok.Data;

@Data
public class ConfigAlertData {

    private Integer id;
    private Integer days;
    private Double minimumAmt;
    private Double aggregateAmt;
    private String mode;
    private Integer transCount;
    public ConfigAlertData(final Integer id, final Integer days, final Double minimumAmt, final Double aggregateAmt,final String mode,final Integer transCount) {
        this.id = id;
        this.days = days;
        this.minimumAmt = minimumAmt;
        this.aggregateAmt = aggregateAmt;
        this.mode = mode;
        this.transCount = transCount;
    }
    public static ConfigAlertData newInstance (final Integer id, final Integer days, final Double minimumAmt, final Double aggregateAmt,final String mode,final Integer transCount) {
        return new ConfigAlertData(id, days, minimumAmt, aggregateAmt,mode,transCount);
    }
}
