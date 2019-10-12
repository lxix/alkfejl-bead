package com.elte.alkfejl.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.*;


@Entity
@Table(name = "recipes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Recipe extends BaseWithUpdateInfo {

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String body;

//    @OneToMany(targetEntity = Message.class, mappedBy = "issue")
//    private List<Message> message;
//
    @ManyToMany(targetEntity = Label.class)
    private List<Label> label;

}
