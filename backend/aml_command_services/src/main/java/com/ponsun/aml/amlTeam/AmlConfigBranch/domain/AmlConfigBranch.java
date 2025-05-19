package com.ponsun.aml.amlTeam.AmlConfigBranch.domain;

import com.ponsun.aml.amlTeam.AmlConfigBranch.request.CreateAmlConfigBranchRequest;
import com.ponsun.aml.amlTeam.AmlConfigBranch.request.UpdateAmlConfigBranchRequest;
import com.ponsun.aml.common.entity.Status;
import com.ponsun.aml.infrastructure.baseentity.BaseEntity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Accessors(chain = true)
@Table(name = "aml_config_branch")
public class AmlConfigBranch extends BaseEntity{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "branchCode")
    private String branchCode;

    @Column(name = "uid")
    private Integer uid;

    @Column(name = "euid")
    private Integer euid;

    public static AmlConfigBranch create(CreateAmlConfigBranchRequest request){
        final AmlConfigBranch amlConfigBranch = new AmlConfigBranch();
        amlConfigBranch.setId(request.getId());
        amlConfigBranch.setName(request.getName());
        amlConfigBranch.setBranchCode(request.getBranchCode());
        amlConfigBranch.setUid(request.getUid());
        amlConfigBranch.setEuid(request.getEuid());
        amlConfigBranch.onCreate();
        amlConfigBranch.setStatus(Status.ACTIVE);
        return amlConfigBranch;

        }
        public void update(final UpdateAmlConfigBranchRequest request){
            this.setId(request.getId());
            this.setName(request.getName());
            this.setBranchCode(request.getBranchCode());
            this.setUid(request.getUid());
            this.setEuid(request.getEuid());
            this.onUpdate();
            this.setStatus(Status.ACTIVE);
        }

}
