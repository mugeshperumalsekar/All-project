package com.ponsun.aml.counterfeit.CounterfeitStatus.domain;

import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import com.ponsun.aml.counterfeit.CounterfeitStatus.request.CreateCounterfeitStatusRequest;
import com.ponsun.aml.counterfeit.CounterfeitStatus.request.UpdateCounterfeitStatusRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "counterfeit_status")
public class CounterfeitStatus extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "counterfeitId")
    private Integer counterfeitId;

    @Column(name = "branchCode")
    private String branchCode;

    @Column(name = "branchId")
    private Integer branchId;

    @Column(name = "counterfeitStatus")
    private String counterfeitStatus;

    @Column(name = "ticketId")
    private Integer ticketId;

    @Column(name = "ticketStatus")
    private String ticketStatus;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static CounterfeitStatus create(CreateCounterfeitStatusRequest request) {
        final CounterfeitStatus CounterfeitStatus = new CounterfeitStatus();
        //CounterfeitStatus.setId(request.getId());
        CounterfeitStatus.setCounterfeitId(request.getCounterfeitId());
        CounterfeitStatus.setBranchCode(request.getBranchCode());
        CounterfeitStatus.setBranchId(request.getBranchId());
        CounterfeitStatus.setCounterfeitStatus(request.getCounterfeitStatus());
        CounterfeitStatus.setTicketId(request.getTicketId());
        CounterfeitStatus.setTicketStatus(request.getTicketStatus());
        CounterfeitStatus.setUid(request.getUid());
        CounterfeitStatus.setEuid(request.getEuid());
        CounterfeitStatus.onCreate();
        CounterfeitStatus.setStatus(Status.ACTIVE);
        return CounterfeitStatus;
    }

    public void update(final UpdateCounterfeitStatusRequest request) {
        //this.setId(request.getId());
        this.setCounterfeitId(request.getCounterfeitId());
        this.setTicketId(request.getTicketId());
        this.setBranchCode(request.getBranchCode());
        this.setBranchId(request.getBranchId());
        this.setCounterfeitStatus(request.getCounterfeitStatus());
        this.setTicketId(request.getTicketId());
        this.setTicketStatus(request.getTicketStatus());
        this.setUid(request.getUid());
        this.setEuid(request.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
}
