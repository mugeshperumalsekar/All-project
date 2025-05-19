package com.ponsun.aml.amlTeam.AmlComplaintTeam.domain;

import com.ponsun.aml.amlTeam.AmlComplaintTeam.request.CreateAmlComplaintTeamRequest;
import com.ponsun.aml.amlTeam.AmlComplaintTeam.request.UpdateAmlComplaintTeamRequest;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "aml_complaint_team")
public class AmlComplaintTeam extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ticketId")
    private Integer ticketId;

    @Column(name = "branchId")
    private Integer branchId;

    @Column(name = "clientId")
    private String clientId;

    @Column(name = "accountNumber")
    private String accountNumber;

    @Column(name = "targetCustomerName")
    private String targetCustomerName;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    @Column(name = "ticketStatusId")
    private Integer ticketStatusId;

    public static AmlComplaintTeam create(CreateAmlComplaintTeamRequest request) {
        final AmlComplaintTeam amlComplaintTeam = new AmlComplaintTeam();
        amlComplaintTeam.setId(request.getId());
        amlComplaintTeam.setTicketId(request.getTicketId());
        amlComplaintTeam.setBranchId(request.getBranchId());
        amlComplaintTeam.setClientId(request.getClientId());
        amlComplaintTeam.setAccountNumber(request.getAccountNumber());
        amlComplaintTeam.setTargetCustomerName(request.getTargetCustomerName());
        amlComplaintTeam.setUid(request.getUid());
        amlComplaintTeam.setEuid(request.getEuid());
        amlComplaintTeam.setTicketStatusId(request.getTicketStatusId());
        amlComplaintTeam.onCreate();
        amlComplaintTeam.setStatus(Status.ACTIVE);
        return amlComplaintTeam;
    }

    public void update(final UpdateAmlComplaintTeamRequest request) {
        this.setId(request.getId());
        this.setTicketId(request.getTicketId());
        this.setBranchId(request.getBranchId());
        this.setClientId(request.getClientId());
        this.setAccountNumber(request.getAccountNumber());
        this.setTargetCustomerName(request.getTargetCustomerName());
        this.setUid(request.getUid());
        this.setEuid(request.getEuid());
        this.setTicketStatusId(request.getTicketStatusId());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
}