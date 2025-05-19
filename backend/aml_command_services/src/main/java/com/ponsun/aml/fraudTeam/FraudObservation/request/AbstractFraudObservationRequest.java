package com.ponsun.aml.fraudTeam.FraudObservation.request;

import lombok.Data;

@Data
public class AbstractFraudObservationRequest {
    private Integer id;
    private Integer fraudId;
    private String  observation;
    private Integer ticketId;
    private Integer branchId;
    private String ticketStatus;
    private Integer uid;
    private Integer euid;
}
