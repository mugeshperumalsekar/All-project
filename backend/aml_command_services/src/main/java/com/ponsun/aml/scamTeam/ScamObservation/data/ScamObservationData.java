package com.ponsun.aml.scamTeam.ScamObservation.data;

import lombok.Data;

@Data
public class ScamObservationData {
    private Integer id;
    private Integer scamId;
    private String  observation;
    private Integer ticketId;
    private Integer branchId;
    private String ticketStatus;
    private Integer uid;
    private Integer euid;

    public ScamObservationData(Integer id, Integer scamId, String observation, Integer ticketId, Integer branchId, String ticketStatus, Integer uid, Integer euid){
        this.id = id;
        this.scamId =scamId;
        this.observation = observation;
        this.ticketId = ticketId;
        this.branchId = branchId;
        this.ticketStatus = ticketStatus;
        this.uid = uid;
        this.euid = euid;
    }
    public static ScamObservationData newInstance(Integer id, Integer scamId, String observation, Integer ticketId, Integer branchId, String ticketStatus, Integer uid, Integer euid){
        return new ScamObservationData(id,scamId,observation,ticketId,branchId,ticketStatus,uid,euid);
    }
}
