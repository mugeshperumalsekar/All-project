package com.ponsun.aml.amlTeam.AmlCustomerAllData.data;

import lombok.Data;

@Data
public class AmlCustomerAllDataData {
    private Integer complaintId;
    private String username;
    private String targetCustomerName;
    private String frmDate;
    private String toDate;
    private Integer ticketId;
    private Integer uid;
    private String created_at;

    public AmlCustomerAllDataData(Integer complaintId, String username, String targetCustomerName, String frmDate, String toDate, Integer ticketId, Integer uid, String created_at) {
        this.complaintId = complaintId;
        this.username = username;
        this.targetCustomerName = targetCustomerName;
        this.frmDate = frmDate;
        this.toDate = toDate;
        this.ticketId = ticketId;
        this.uid = uid;
        this.created_at = created_at;
    }
    public static AmlCustomerAllDataData newInsatnce(Integer complaintId, String username, String targetCustomerName, String frmDate, String toDate, Integer ticketId, Integer uid, String created_at){
        return new AmlCustomerAllDataData(complaintId,username,targetCustomerName,frmDate,toDate,ticketId,uid,created_at);
    }

}
