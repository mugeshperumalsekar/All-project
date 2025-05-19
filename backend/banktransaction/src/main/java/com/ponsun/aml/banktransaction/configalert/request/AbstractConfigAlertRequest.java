package com.ponsun.aml.banktransaction.configalert.request;

import lombok.Data;

@Data
public class AbstractConfigAlertRequest {
    private Integer id;
    private Integer days;
    private Double minimumAmt;
    private Double aggregateAmt;
    private String mode;
    private Integer transCount;
}
