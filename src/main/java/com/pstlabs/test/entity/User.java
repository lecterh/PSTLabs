package com.pstlabs.test.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String password;
    private String email;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "user")
    private Profile profile;

    @OneToMany(mappedBy = "user")
    private List<Tool> tools;

    @ManyToMany(mappedBy = "users")
    private Set<Manager> managers;
}
