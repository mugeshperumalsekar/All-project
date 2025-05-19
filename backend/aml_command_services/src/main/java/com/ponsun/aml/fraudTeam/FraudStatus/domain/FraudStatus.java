package com.ponsun.aml.fraudTeam.FraudStatus.domain;

import com.ponsun.aml.fraudTeam.FraudStatus.request.CreateFraudStatusRequest;
import com.ponsun.aml.fraudTeam.FraudStatus.request.UpdateFraudStatusRequest;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name="fraud_status")
public class FraudStatus extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="fraudId")
    private Integer fraudId;

    @Column(name="branchCode")
    private String branchCode;

    @Column(name="branchId")
    private Integer branchId;

    @Column(name="fraudStatus")
    private String fraudStatus;

    @Column(name="ticketId")
    private Integer ticketId;

    @Column(name="ticketStatus")
    private String ticketStatus;

    @Column(name="uid")
    private Integer uid;

    @Column(name="euid")
    private Integer euid;

    public static FraudStatus create(CreateFraudStatusRequest request){
        final FraudStatus fraudStatus = new FraudStatus();
        fraudStatus.setId(request.getId());
        fraudStatus.setFraudId(request.getFraudId());
        fraudStatus.setBranchCode(request.getBranchCode());
        fraudStatus.setBranchId(request.getBranchId());
        fraudStatus.setFraudStatus(request.getFraudStatus());
        fraudStatus.setTicketId(request.getTicketId());
        fraudStatus.setTicketStatus(request.getTicketStatus());
        fraudStatus.setUid(request.getUid());
        fraudStatus.setEuid(request.getEuid());
        fraudStatus.onCreate();
        fraudStatus.setStatus(Status.ACTIVE);
        return fraudStatus;
    }

    public void update(final UpdateFraudStatusRequest request){
        this.setId(request.getId());
        this.setFraudId(request.getFraudId());
        this.setBranchCode(request.getBranchCode());
        this.setBranchId(request.getBranchId());
        this.setFraudStatus(request.getFraudStatus());
        this.setTicketId(request.getTicketId());
        this.setTicketStatus(request.getTicketStatus());
        this.setUid(request.getUid());
        this.setEuid(request.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
}
