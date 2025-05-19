package com.ponsun.aml.counterfeit.CounterfeitNumber.domain;


import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import com.ponsun.aml.counterfeit.CounterfeitNumber.request.CreateCounterfeitNumberRequest;
import com.ponsun.aml.counterfeit.CounterfeitNumber.request.UpdateCounterfeitNumberRequest;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "counterfeit_number")
public class CounterfeitNumber extends BaseEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "counterfeitId")
    private Integer counterfeitId;

    @Column(name = "counterfeitNo")
    private String counterfeitNo;

    @Column(name = "denomination")
    private String denomination;

    @Column(name = "ticketId")
    private Integer ticketId;

    @Column(name = "branchId")
    private Integer branchId;

    @Column(name = "ticketStatus")
    private String ticketStatus;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;


    public static CounterfeitNumber create(CreateCounterfeitNumberRequest request) {
        final CounterfeitNumber CounterfeitNumber = new CounterfeitNumber();
        CounterfeitNumber.setCounterfeitId(request.getCounterfeitId());
        CounterfeitNumber.setCounterfeitNo(request.getCounterfeitNo());
        CounterfeitNumber.setDenomination(request.getDenomination());
        CounterfeitNumber.setTicketId(request.getTicketId());
        CounterfeitNumber.setBranchId(request.getBranchId());
        CounterfeitNumber.setTicketStatus(request.getTicketStatus());
        CounterfeitNumber.setUid(request.getUid());
        CounterfeitNumber.setEuid(request.getEuid());
        CounterfeitNumber.onCreate();
        CounterfeitNumber.setStatus(Status.ACTIVE);
        return CounterfeitNumber;
    }

    public void update(final UpdateCounterfeitNumberRequest request) {
        this.setCounterfeitId(request.getCounterfeitId());
        this.setCounterfeitNo(request.getCounterfeitNo());
        this.setDenomination(request.getDenomination());
        this.setTicketId(request.getTicketId());
        this.setBranchId(request.getBranchId());
        this.setTicketStatus(request.getTicketStatus());
        this.setUid(request.getUid());
        this.setEuid(request.getEuid());
        this.onUpdate();
        this.setStatus(Status.ACTIVE);
    }
}
