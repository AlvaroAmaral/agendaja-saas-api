package com.alvaro.agendaja.scheduling_api.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass

public abstract class BaseEntity {

    @Column(name = "tenent_id", nullable = false, updatable = false)
    private String tenantId;
}
