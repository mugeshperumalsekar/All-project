package com.ponsun.aml.amlTeam.AmlCustomerEdit.data;

import lombok.Data;

@Data
public class AmlCustomerEditData {
    private Integer complaintId;
    private String username;
    private String targetCustomerName;
    private String frmDate;
    private String toDate;
    private Integer ticketId;
    private Integer uid;
    private String created_at;


    public AmlCustomerEditData(Integer complaintId, String username, String targetCustomerName, String frmDate, String toDate, Integer ticketId, Integer uid,String created_at) {

        this.complaintId = complaintId;
        this.username = username;
        this.targetCustomerName = targetCustomerName;
        this.frmDate = frmDate;
        this.toDate = toDate;
        this.ticketId = ticketId;
        this.uid = uid;
        this.created_at= created_at;
    }
    public static AmlCustomerEditData newInstance( Integer complaintId, String username, String targetCustomerName, String frmDate, String toDate, Integer ticketId, Integer uid,String created_at){
        return new AmlCustomerEditData(complaintId,username,targetCustomerName,frmDate,toDate,ticketId,uid,created_at);
    }
}
