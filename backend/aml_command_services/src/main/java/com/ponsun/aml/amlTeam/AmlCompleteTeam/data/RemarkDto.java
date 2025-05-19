package com.ponsun.aml.amlTeam.AmlCompleteTeam.data;

import lombok.Data;

@Data
public class RemarkDto {

    private String remark;

    public RemarkDto(String remark) {
        this.remark = remark;
    }
    public static RemarkDto newInstance(String remark){
        return new RemarkDto(remark);
    }
}
