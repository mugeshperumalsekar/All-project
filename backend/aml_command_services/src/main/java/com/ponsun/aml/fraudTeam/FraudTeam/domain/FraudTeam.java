package com.ponsun.aml.fraudTeam.FraudTeam.domain;

import com.ponsun.aml.fraudTeam.FraudTeam.request.CreateFraudTeamRequest;
import com.ponsun.aml.fraudTeam.FraudTeam.request.UpdateFraudTeamRequest;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name="fraud_team")
public class FraudTeam extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="branchCode")
    private String branchCode;

    @Column(name="branchId")
    private Integer branchId;

    @Column(name="clientId")
    private String clientId;

    @Column(name="accountNumber")
    private String accountNumber;

    @Column(name="ticketId")
    private Integer ticketId;

    @Column(name="ticketStatus")
    private String ticketStatus;

    @Column(name="targetCustomerName")
    private String targetCustomerName;

    @Column(name="uid")
    private Integer uid;

    @Column(name="euid")
    private Integer euid;

    public static FraudTeam create(CreateFraudTeamRequest request){
        final FraudTeam fraudTeam = new FraudTeam();
        fraudTeam.setId(request.getId());
        fraudTeam.setBranchCode(request.getBranchCode());
        fraudTeam.setBranchId(request.getBranchId());
        fraudTeam.setClientId(request.getClientId());
        fraudTeam.setAccountNumber(request.getAccountNumber());
        fraudTeam.setTicketId(request.getTicketId());
        fraudTeam.setTicketStatus(request.getTicketStatus());
        fraudTeam.setTargetCustomerName(request.getTargetCustomerName());
        fraudTeam.setUid(request.getUid());
        fraudTeam.setEuid(request.getEuid());
        fraudTeam.onCreate();
        fraudTeam.setStatus(Status.ACTIVE);
        return fraudTeam;
    }

    public void update(final UpdateFraudTeamRequest request){
        this.setId(request.getId());
        this.setBranchCode(request.getBranchCode());
        this.setBranchId(request.getBranchId());
        this.setClientId(request.getClientId());
        this.setAccountNumber(request.getAccountNumber());
        this.setTicketId(request.getTicketId());
        this.setTicketStatus(request.getTicketStatus());
        this.setTargetCustomerName(request.getTargetCustomerName());
        this.setUid(request.getUid());
        this.setEuid(request.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
}
