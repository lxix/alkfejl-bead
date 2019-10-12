package com.elte.alkfejl.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import java.util.List;

@Entity
@Table(name = "labels")
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Label extends BaseWithCreationInfo {

    @Column
    private String label;

    @JsonIgnore
    @ManyToMany(targetEntity = Recipe.class, mappedBy = "label")
    private List<Recipe> recipes;

}





















