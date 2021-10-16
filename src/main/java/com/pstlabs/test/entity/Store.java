package com.pstlabs.test.entity;

import lombok.Data;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.util.List;
import java.util.Set;

@Data
@Entity
public class Store {

    @Id
    @GeneratedValue
    private Long id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "store")
    private List<Tool> tools;

    @OneToOne(mappedBy = "store")
    private Manager manager;


}
