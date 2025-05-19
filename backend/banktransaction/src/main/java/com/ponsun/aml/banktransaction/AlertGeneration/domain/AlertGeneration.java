package com.ponsun.aml.banktransaction.AlertGeneration.domain;

import jakarta.persistence.*;

@Entity
@NamedStoredProcedureQuery(
        name = "SP_AlertGeneration",
        procedureName = "SP_AlertGeneration"
)
public class AlertGeneration {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

}

