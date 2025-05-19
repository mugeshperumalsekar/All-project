package com.ponsun.aml.amlTeam.AmlCompleteTeam.data;

import lombok.Data;

@Data
public class ReplyDto {
    private String reply;

    public ReplyDto(String reply) {
       this.reply = reply;
    }
    public static ReplyDto newInstance(String reply){
        return new ReplyDto(reply);
    }
}
