package com.ponsun.aml.amlTeam.AmlConfigStatus.data;

import lombok.Data;

@Data
public class AmlConfigStatusData {
    private Integer id;
    private String name;
    private Integer uid;
    private Integer euid;

    public AmlConfigStatusData(Integer id,String name,Integer uid,Integer euid){
      this.id = id;
      this.name = name;
      this.uid = uid;
      this.euid = euid;
    }
    public static  AmlConfigStatusData newInstance(Integer id,String name,Integer uid,Integer euid){
        return new AmlConfigStatusData(id,name,uid,euid);
    }
}
