package com.elte.alkfejl.entities;

import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "recipes")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
class Recipe extends BaseWithUpdateInfo {

    @Column
    private String title;

    @Column
    private String description;

    @Column
    private String place;

//    @OneToMany(targetEntity = Message.class, mappedBy = "issue")
//    private List<Message> message;
//
//    @ManyToMany(targetEntity = Label.class)
//    private List<Label> label;

}
