package com.ponsun.aml.banktransaction.configalert.domain;

import com.ponsun.aml.banktransaction.common.entity.Status;
import com.ponsun.aml.banktransaction.infrastructure.baseentity.BaseEntity;
import com.ponsun.aml.banktransaction.configalert.request.CreateConfigAlertRequest;
import com.ponsun.aml.banktransaction.configalert.request.UpdateConfigAlertRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "bank_config_alert")
public class ConfigAlert extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="days")
    private Integer days;

    @Column(name = "minimumAmt")
    private Double minimumAmt;

    @Column(name = "aggregateAmt")
    private Double aggregateAmt;

    @Column(name = "mode")
    private String mode;

    @Column(name = "transCount")
    private Integer transCount;



    public static ConfigAlert create(final CreateConfigAlertRequest createConfigAlertRequest){
        final ConfigAlert configAlert = new ConfigAlert();
        configAlert.setDays(createConfigAlertRequest.getDays());
        configAlert.setMinimumAmt(createConfigAlertRequest.getMinimumAmt());
        configAlert.setAggregateAmt(createConfigAlertRequest.getAggregateAmt());
        configAlert.setMode(createConfigAlertRequest.getMode());
        configAlert.setTransCount(createConfigAlertRequest.getTransCount());
        configAlert.setStatus(Status.ACTIVE);
        return configAlert;
    }

    public void update(UpdateConfigAlertRequest updateConfigAlertRequest) {
        this.setDays(updateConfigAlertRequest.getDays());
        this.setMinimumAmt(updateConfigAlertRequest.getMinimumAmt());
        this.setAggregateAmt(updateConfigAlertRequest.getAggregateAmt());
        this.setMode(updateConfigAlertRequest.getMode());
        this.setTransCount(updateConfigAlertRequest.getTransCount());
    }
}
