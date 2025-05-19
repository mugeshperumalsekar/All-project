package com.ponsun.aml.scamTeam.ScamStatus.domain;

import com.ponsun.aml.scamTeam.ScamStatus.request.CreateScamStatusRequest;
import com.ponsun.aml.scamTeam.ScamStatus.request.UpdateScamStatusRequest;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name="scam_status")
public class ScamStatus  extends BaseEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="scamId")
    private Integer scamId;

    @Column(name="branchCode")
    private String branchCode;

    @Column(name="branchId")
    private Integer branchId;

    @Column(name="scamStatus")
    private String scamStatus;

    @Column(name="ticketId")
    private Integer ticketId;

    @Column(name="ticketStatus")
    private String ticketStatus;

    @Column(name="uid")
    private Integer uid;

    @Column(name="euid")
    private Integer euid;

    public static ScamStatus create(CreateScamStatusRequest request){
        final ScamStatus scamStatus = new ScamStatus();
        scamStatus.setId(request.getId());
        scamStatus.setScamId(request.getScamId());
        scamStatus.setBranchCode(request.getBranchCode());
        scamStatus.setBranchId(request.getBranchId());
        scamStatus.setScamStatus(request.getScamStatus());
        scamStatus.setTicketId(request.getTicketId());
        scamStatus.setTicketStatus(request.getTicketStatus());
        scamStatus.setUid(request.getUid());
        scamStatus.setEuid(request.getEuid());
        scamStatus.onCreate();
        scamStatus.setStatus(Status.ACTIVE);
        return scamStatus;
    }

    public void update(final UpdateScamStatusRequest request){
        this.setId(request.getId());
        this.setScamId(request.getScamId());
        this.setBranchCode(request.getBranchCode());
        this.setBranchId(request.getBranchId());
        this.setScamStatus(request.getScamStatus());
        this.setTicketId(request.getTicketId());
        this.setTicketStatus(request.getTicketStatus());
        this.setUid(request.getUid());
        this.setEuid(request.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
}
