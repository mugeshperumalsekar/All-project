package com.ponsun.aml.counterfeit.CounterfeitTeam.domain;


import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import com.ponsun.aml.counterfeit.CounterfeitTeam.request.CreateCounterfeitTeamRequest;
import com.ponsun.aml.counterfeit.CounterfeitTeam.request.UpdateCounterfeitTeamRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "counterfeit_team")
public class CounterfeitTeam extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "ticketId")
    private Integer ticketId;

    @Column(name = "branchCode")
    private String branchCode;

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

    @Column(name = "ticketStatus")
    private String ticketStatus;

    @Column(name = "branchId")
    private String branchId;

    public static CounterfeitTeam create(CreateCounterfeitTeamRequest request) {
        final CounterfeitTeam counterfeitTeam = new CounterfeitTeam();
        //CounterfeitTeam.setId(request.getId());
        counterfeitTeam.setTicketId(request.getTicketId());
        counterfeitTeam.setBranchCode(request.getBranchCode());
        counterfeitTeam.setClientId(request.getClientId());
        counterfeitTeam.setAccountNumber(request.getAccountNumber());
        counterfeitTeam.setTargetCustomerName(request.getTargetCustomerName());
        counterfeitTeam.setUid(request.getUid());
        counterfeitTeam.setEuid(request.getEuid());
        counterfeitTeam.setTicketStatus(request.getTicketStatus());
        counterfeitTeam.setBranchId(request.getBranchId());
        counterfeitTeam.onCreate();
        counterfeitTeam.setStatus(Status.ACTIVE);
        return counterfeitTeam;
    }

    public void update(final UpdateCounterfeitTeamRequest request) {
        this.setTicketId(request.getTicketId());
        this.setBranchCode(request.getBranchCode());
        this.setClientId(request.getClientId());
        this.setAccountNumber(request.getAccountNumber());
        this.setTargetCustomerName(request.getTargetCustomerName());
        this.setUid(request.getUid());
        this.setEuid(request.getEuid());
        this.setTicketStatus(request.getTicketStatus());
        this.setBranchId(request.getBranchId());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
}
