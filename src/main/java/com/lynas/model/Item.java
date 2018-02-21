package com.lynas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Item {

    @Id
    @GeneratedValue
    private Long id;
    @Column(unique = true, nullable = false)
    private String name;
    private String description;

    @ManyToOne(fetch = FetchType.EAGER)
    private Organization organization;
    @OneToMany(fetch = FetchType.EAGER)
    private Set<ReviewAspect> reviewAspects;

    public Item(Long id, String name, Organization organization) {
        this.id = id;
        this.name = name;
        this.organization = organization;
    }
}
