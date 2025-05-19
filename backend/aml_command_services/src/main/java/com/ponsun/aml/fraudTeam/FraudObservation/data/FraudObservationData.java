package com.ponsun.aml.fraudTeam.FraudObservation.data;

import lombok.Data;

@Data
public class FraudObservationData {
    private Integer id;
    private Integer fraudId;
    private String  observation;
    private Integer ticketId;
    private Integer branchId;
    private String ticketStatus;
    private Integer uid;
    private Integer euid;

    public FraudObservationData(Integer id, Integer fraudId, String observation, Integer ticketId, Integer branchId, String ticketStatus, Integer uid, Integer euid){
        this.id = id;
        this.fraudId =fraudId;
        this.observation = observation;
        this.ticketId = ticketId;
        this.branchId = branchId;
        this.ticketStatus = ticketStatus;
        this.uid = uid;
        this.euid = euid;
    }
    public static FraudObservationData newInstance(Integer id, Integer fraudId, String observation, Integer ticketId, Integer branchId, String ticketStatus, Integer uid, Integer euid){
        return new FraudObservationData(id,fraudId,observation,ticketId,branchId,ticketStatus,uid,euid);
    }
}
