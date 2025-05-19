package com.ponsun.aml.banktransaction.alertGet.domain;



import com.ponsun.aml.banktransaction.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "bank_alert")
@EqualsAndHashCode(callSuper = false)
public class AlertGet extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "alert")
    private String alert;

    @Column(name = "senderAccount")
    private String senderAccount;

    @Column(name = "senderCustomerId")
    private String senderCustomerId;

    @Column(name = "transCount")
    private Integer transCount;

    @Column(name = "TransCumulativeAmt")
    private Double TransCumulativeAmt;

    @Column(name = "bankAccount")
    private String bankAccount;

    @Column(name = "customerId")
    private String customerId;

    @Column(name = "transModeId")
    private Integer transModeId;

}
