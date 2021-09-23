package com.example.spring_security.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "authority")
public class Authority {

    @Id
    @Column(name = "name")
    private String name;

    @ManyToMany(fetch = FetchType.EAGER, mappedBy = "Authorities")
    List<Profile> profiles;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
