package com.elte.alkfejl.entities;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

@Entity
@Table(name = "labels")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Label extends BaseWithUpdateInfo {

    @Column
    private String label;

    @JsonIgnore
    @ManyToMany(targetEntity = Recipe.class, mappedBy = "label")
    private List<Recipe> recipes;

    @PrePersist
    protected void prePersist() {
        if (createdAt == null) createdAt = LocalDateTime.now();
        if (updatedAt == null) updatedAt = LocalDateTime.now();
    }

    @PreUpdate
    protected void preUpdate() {
        this.updatedAt = LocalDateTime.now();
    }

    @PreRemove
    protected void preRemove() {
        this.updatedAt = LocalDateTime.now();
    }

}





















