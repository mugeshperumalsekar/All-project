package com.ponsun.aml.banktransaction.alert.data;

import lombok.Data;

@Data
public class AlertData {

    private Integer id;
    private Integer customerId;
    private String bankAccount;
    private String alert;

    public AlertData (final Integer id,final Integer customerId,final String bankAccount , final String alert) {
        this.id = id;
        this.customerId = customerId;
        this.bankAccount = bankAccount;
        this.alert = alert;
    }
    public static AlertData newInstance (final Integer id,final Integer customerId,final String bankAccount , final String alert) {
        return new AlertData(id, customerId, bankAccount, alert);
    }
}
