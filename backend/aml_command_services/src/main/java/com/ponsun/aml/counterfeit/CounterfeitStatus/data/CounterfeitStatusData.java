package com.ponsun.aml.counterfeit.CounterfeitStatus.data;

import lombok.Data;

@Data
public class CounterfeitStatusData {
    private Integer id;
    private Integer counterfeitId;
    private String branchCode;
    private Integer branchId;
    private String counterfeitStatus;
    private String ticketStatus;
    private Integer ticketId;
    private Integer uid;
    private Integer euid;
    public CounterfeitStatusData (Integer id, Integer counterfeitId, String branchCode, Integer branchId,String counterfeitStatus, String ticketStatus, Integer ticketId, Integer uid, Integer euid) {
        this.id = id;
        this.counterfeitId = counterfeitId;
        this.branchCode = branchCode;
        this.branchId = branchId;
        this.counterfeitStatus = counterfeitStatus;
        this.ticketStatus = ticketStatus;
        this.ticketId = ticketId;
        this.uid = uid;
        this.euid = euid;

    }
    public static CounterfeitStatusData newInstance (Integer id, Integer counterfeitId, String branchCode, Integer branchId,String counterfeitStatus, String ticketStatus, Integer ticketId, Integer uid, Integer euid) {
        return new CounterfeitStatusData(id, counterfeitId,branchCode,branchId,counterfeitStatus,ticketStatus,ticketId,uid,euid);
    }
}
