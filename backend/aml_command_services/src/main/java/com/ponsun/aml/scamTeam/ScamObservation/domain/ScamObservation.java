package com.ponsun.aml.scamTeam.ScamObservation.domain;

import com.ponsun.aml.scamTeam.ScamObservation.request.CreateScamObservationRequest;
import com.ponsun.aml.scamTeam.ScamObservation.request.UpdateScamObservationRequest;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name ="scam_observation")
public class ScamObservation extends BaseEntity {
    private static final long serialVersionUID =1L;

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="scamId")
    private Integer scamId;

    @Column(name="observation")
    private String observation;

    @Column(name="ticketId")
    private Integer ticketId;

    @Column(name="branchId")
    private Integer branchId;

    @Column(name="ticketStatus")
    private String ticketStatus;

    @Column(name="uid")
    private Integer uid;

    @Column(name="euid")
    private Integer euid;

    public static ScamObservation create(CreateScamObservationRequest request){
       final ScamObservation scamObservation = new ScamObservation();
       scamObservation.setId(request.getId());
       scamObservation.setScamId(request.getScamId());
       scamObservation.setObservation(request.getObservation());
       scamObservation.setTicketId(request.getTicketId());
       scamObservation.setBranchId(request.getBranchId());
       scamObservation.setTicketStatus(request.getTicketStatus());
       scamObservation.setUid(request.getUid());
       scamObservation.setEuid(request.getEuid());
       scamObservation.onCreate();
       scamObservation.setStatus(Status.ACTIVE);
       return scamObservation;
    }
    public void update(final UpdateScamObservationRequest request){
        this.setId(request.getId());
        this.setScamId(request.getScamId());
        this.setObservation(request.getObservation());
        this.setTicketId(request.getTicketId());
        this.setBranchId(request.getBranchId());
        this.setTicketStatus(request.getTicketStatus());
        this.setUid(request.getUid());
        this.setEuid(request.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
}
