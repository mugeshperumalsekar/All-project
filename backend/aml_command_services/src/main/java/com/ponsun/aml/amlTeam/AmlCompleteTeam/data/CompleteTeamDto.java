package com.ponsun.aml.amlTeam.AmlCompleteTeam.data;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Data
@RequiredArgsConstructor
public class CompleteTeamDto {
    private List<ComplaintDto> complaintDto;
    private List<AlertScenarioDto> alertScenarioDtos;
    private List<RemarkDto> remarkDtos;
    private List<ReplyDto> replyDtos;

    public CompleteTeamDto(List<ComplaintDto> complaintDto, List<AlertScenarioDto> alertScenarioDtos, List<RemarkDto> remarkDtos, List<ReplyDto> replyDtos) {
        this.complaintDto = complaintDto;
        this.alertScenarioDtos = alertScenarioDtos;
        this.remarkDtos = remarkDtos;
        this.replyDtos = replyDtos;
    }
    public static CompleteTeamDto newInstance(List<ComplaintDto> complaintDto, List<AlertScenarioDto> alertScenarioDtos, List<RemarkDto> remarkDtos, List<ReplyDto> replyDtos){
        return new CompleteTeamDto(complaintDto,alertScenarioDtos,remarkDtos,replyDtos);
    }
}
