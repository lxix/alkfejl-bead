package com.elte.alkfejl.entities;

import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class User extends BaseEntity {

    @Column(nullable = false)
    private String userName;

    @Column (nullable = false)
    @JsonIgnore
    private String password;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Role role;

    @Column(updatable = false, nullable = false)
    private LocalDateTime createdAt;

    @Column(updatable = false, nullable = false)
    private LocalDateTime updatedAt;

    @JsonIgnore
    @OneToMany(targetEntity = Recipe.class, mappedBy = "createdBy")
    private List<Recipe> createdRecipe;

    @JsonIgnore
    @OneToMany(targetEntity = Recipe.class, mappedBy = "updatedBy")
    private List<Recipe> updatedRecipe;

//    @OneToMany(targetEntity = Message.class, mappedBy = "createdBy")
//    private List<Message> createdMessage;

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


