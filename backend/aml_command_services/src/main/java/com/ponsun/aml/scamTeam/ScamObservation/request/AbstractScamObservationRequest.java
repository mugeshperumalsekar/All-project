package com.ponsun.aml.scamTeam.ScamObservation.request;

import lombok.Data;

@Data
public class AbstractScamObservationRequest {
    private Integer id;
    private Integer scamId;
    private String  observation;
    private Integer ticketId;
    private Integer branchId;
    private String ticketStatus;
    private Integer uid;
    private Integer euid;
}
