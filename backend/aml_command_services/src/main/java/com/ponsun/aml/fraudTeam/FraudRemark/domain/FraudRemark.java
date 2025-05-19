package com.ponsun.aml.fraudTeam.FraudRemark.domain;

import com.ponsun.aml.fraudTeam.FraudRemark.request.CreateFraudRemarkRequest;
import com.ponsun.aml.fraudTeam.FraudRemark.request.UpdateFraudRemarkRequest;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name ="fraud_remark")
public class FraudRemark extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="fraudId")
    private Integer fraudId;

    @Column(name="branchId")
    private Integer branchId;

    @Column(name="ticketId")
    private Integer ticketId;

    @Column(name="remark")
    private String remark;

    @Column(name="uid")
    private Integer uid;

    @Column(name="euid")
    private Integer euid;

    public static FraudRemark create(CreateFraudRemarkRequest request){
        final FraudRemark fraudRemark = new FraudRemark();
        fraudRemark.setId(request.getId());
        fraudRemark.setFraudId(request.getFraudId());
        fraudRemark.setBranchId(request.getBranchId());
        fraudRemark.setTicketId(request.getTicketId());
        fraudRemark.setRemark(request.getRemark());
        fraudRemark.setUid(request.getUid());
        fraudRemark.setEuid(request.getEuid());
        fraudRemark.onCreate();
        fraudRemark.setStatus(Status.ACTIVE);
        return fraudRemark;
    }
    public void update(final UpdateFraudRemarkRequest request){
        this.setId(request.getId());
        this.setFraudId(request.getFraudId());
        this.setBranchId(request.getBranchId());
        this.setTicketId(request.getTicketId());
        this.setRemark(request.getRemark());
        this.setUid(request.getUid());
        this.setEuid(request.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
}
