package com.ponsun.aml.banktransaction.alert.domain;

import com.ponsun.aml.banktransaction.alert.request.CreateAlertRequest;
import com.ponsun.aml.banktransaction.alert.request.UpdateAlertRequest;
import com.ponsun.aml.banktransaction.common.entity.Status;
import com.ponsun.aml.banktransaction.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "bank_alert")
public class Alert extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="customerId")
    private Integer customerId;

    @Column(name = "bankAccount")
    private String bankAccount;

    @Column(name = "alert")
    private String alert;


    public static Alert create(final CreateAlertRequest createAlertRequest){
        final Alert alert = new Alert();
        alert.setCustomerId(createAlertRequest.getCustomerId());
        alert.setBankAccount(createAlertRequest.getBankAccount());
        alert.setAlert(createAlertRequest.getAlert());
        alert.onCreate();
        alert.setStatus(Status.ACTIVE);
        return alert;
    }

    public void update(UpdateAlertRequest updateAlertRequest) {
        this.setCustomerId(updateAlertRequest.getCustomerId());
        this.setBankAccount(updateAlertRequest.getBankAccount());
        this.setAlert(updateAlertRequest.getAlert());
        this.onCreate();
        this.setStatus(Status.ACTIVE);
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
}
