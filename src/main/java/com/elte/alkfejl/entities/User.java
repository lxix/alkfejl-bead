package com.elte.alkfejl.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
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
class User extends BaseWithUpdateInfo {

    @Column
    private String userName;

    @Column
    private String password;

    @OneToMany(targetEntity = Recipe.class, mappedBy = "createdBy")
    private List<Recipe> createdIssue;

    @OneToMany(targetEntity = Recipe.class, mappedBy = "updatedBy")
    private List<Recipe> updatedIssue;

//    @OneToMany(targetEntity = Message.class, mappedBy = "createdBy")
//    private List<Message> createdMessage;

    @OneToMany(targetEntity = User.class, mappedBy = "createdBy")
    private List<Recipe> createdUser;

    @OneToMany(targetEntity = User.class, mappedBy = "updatedBy")
    private List<Recipe> updatedUser;
}


