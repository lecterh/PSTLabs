package com.pstlabs.test.entity;

import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Data
@Entity
public class Manager {
    @Id
    @GeneratedValue
    private Long id;
    private String name;

    @OneToOne
    @JoinColumn(name = "storeId")
    private Store store;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "manage_user",
            joinColumns = @JoinColumn(name = "managerId"),
            inverseJoinColumns = @JoinColumn(name = "userId")
    )
    private Set<User> users;

}
