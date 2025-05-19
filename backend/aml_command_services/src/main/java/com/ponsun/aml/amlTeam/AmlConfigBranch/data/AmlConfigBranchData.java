package com.ponsun.aml.amlTeam.AmlConfigBranch.data;

import lombok.Data;

@Data
public class AmlConfigBranchData {
    private Integer id;
    private String name;
    private String branchCode;
    private Integer uid;
    private Integer euid;

    public AmlConfigBranchData(Integer id, String name,String branchCode, Integer uid, Integer euid) {
        this.id = id;
        this.name= name;
        this.branchCode= branchCode;
        this.uid = uid;
        this.euid = euid;
    }
    public static AmlConfigBranchData newInstance(Integer id, String name,String branchCode, Integer branchId, Integer uid, Integer euid){
        return new AmlConfigBranchData(id,name,branchCode,uid,euid);
    }

}
