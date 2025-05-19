package com.ponsun.aml.banktransaction.alert.request;

import lombok.Data;

@Data
public class AbstractAlertRequest {
    private Integer id;
    private Integer customerId;
    private String bankAccount;
    private String alert;
}
