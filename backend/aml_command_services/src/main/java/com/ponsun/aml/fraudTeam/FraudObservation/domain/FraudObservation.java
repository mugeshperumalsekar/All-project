package com.ponsun.aml.fraudTeam.FraudObservation.domain;

import com.ponsun.aml.fraudTeam.FraudObservation.request.CreateFraudObservationRequest;
import com.ponsun.aml.fraudTeam.FraudObservation.request.UpdateFraudObservationRequest;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name ="fraud_observation")
public class FraudObservation extends BaseEntity {
    private static final long serialVersionUID =1L;

    @Id
    @Column(name="id",nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="fraudId")
    private Integer fraudId;

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

    public static FraudObservation create(CreateFraudObservationRequest request){
       final FraudObservation fraudObservation = new FraudObservation();
       fraudObservation.setId(request.getId());
       fraudObservation.setFraudId(request.getFraudId());
       fraudObservation.setObservation(request.getObservation());
       fraudObservation.setTicketId(request.getTicketId());
       fraudObservation.setBranchId(request.getBranchId());
       fraudObservation.setTicketStatus(request.getTicketStatus());
       fraudObservation.setUid(request.getUid());
       fraudObservation.setEuid(request.getEuid());
       fraudObservation.onCreate();
       fraudObservation.setStatus(Status.ACTIVE);
       return fraudObservation;
    }
    public void update(final UpdateFraudObservationRequest request){
        this.setId(request.getId());
        this.setFraudId(request.getFraudId());
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
