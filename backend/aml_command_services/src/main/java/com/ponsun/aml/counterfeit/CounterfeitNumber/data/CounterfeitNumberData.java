package com.ponsun.aml.counterfeit.CounterfeitNumber.data;

import lombok.Data;

@Data
public class CounterfeitNumberData {
    private Integer id;
    private Integer counterfeitId;
    private String counterfeitNo;
    private String denomination;
    private Integer ticketId;
    private Integer branchId;
    private String ticketStatus;
    private Integer uid;
    private Integer euid;

    public CounterfeitNumberData (Integer id,Integer counterfeitId, String counterfeitNo,String denomination,Integer ticketId,Integer branchId,String ticketStatus, Integer uid, Integer euid) {
        this.id = id;
        this.counterfeitId = counterfeitId;
        this.counterfeitNo = counterfeitNo;
        this.denomination = denomination;
        this.ticketId = ticketId;
        this.branchId = branchId;
        this.ticketStatus = ticketStatus;
        this.uid = uid;
        this.euid = euid;
    }

    public static CounterfeitNumberData newInstance (Integer id,Integer counterfeitId, String counterfeitNo,String denomination,Integer ticketId,Integer branchId,String ticketStatus, Integer uid, Integer euid) {
        return new CounterfeitNumberData(id, counterfeitId,counterfeitNo,denomination,ticketId,branchId,ticketStatus,uid,euid);
    }
}
