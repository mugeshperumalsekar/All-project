package com.ponsun.aml.amlTeam.BranchUserMapping.data;

import lombok.Data;

@Data
public class BranchUserMappingData {
    private Integer id;
    private Integer branchId;
    private String userId;
    private String entryDate;
    private Integer uid;
    private Integer euid;

    public BranchUserMappingData(Integer id, Integer branchId, String userId, String entryDate, Integer uid, Integer euid) {
        this.id = id;
        this.branchId = branchId;
        this.userId = userId;
        this.entryDate = entryDate;
        this.uid = uid;
        this.euid = euid;
    }
    public static BranchUserMappingData newInstance(Integer id, Integer branchId, String userId, String entryDate, Integer uid, Integer euid){
        return new BranchUserMappingData(id,branchId,userId,entryDate,uid,euid);
    }
}
