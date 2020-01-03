package com.elte.alkfejl.entities;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import lombok.Data;

@Data
@MappedSuperclass
class BaseWithCreationInfo extends BaseEntity {
    @Column(updatable = false, nullable = false)
    protected LocalDateTime createdAt;

    @JoinColumn(updatable = false, nullable = false)
    @ManyToOne(targetEntity = User.class)
    protected User createdBy;

}
