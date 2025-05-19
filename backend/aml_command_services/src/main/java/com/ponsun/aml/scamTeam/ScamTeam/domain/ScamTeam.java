package com.ponsun.aml.scamTeam.ScamTeam.domain;

import com.ponsun.aml.scamTeam.ScamTeam.request.CreateScamTeamRequest;
import com.ponsun.aml.scamTeam.ScamTeam.request.UpdateScamTeamRequest;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name="scam_team")
public class ScamTeam extends BaseEntity {
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

    public static ScamTeam create(CreateScamTeamRequest request){
        final ScamTeam scamTeam = new ScamTeam();
        scamTeam.setId(request.getId());
        scamTeam.setBranchCode(request.getBranchCode());
        scamTeam.setBranchId(request.getBranchId());
        scamTeam.setClientId(request.getClientId());
        scamTeam.setAccountNumber(request.getAccountNumber());
        scamTeam.setTicketId(request.getTicketId());
        scamTeam.setTicketStatus(request.getTicketStatus());
        scamTeam.setTargetCustomerName(request.getTargetCustomerName());
        scamTeam.setUid(request.getUid());
        scamTeam.setEuid(request.getEuid());
        scamTeam.onCreate();
        scamTeam.setStatus(Status.ACTIVE);
        return scamTeam;
    }

    public void update(final UpdateScamTeamRequest request){
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
