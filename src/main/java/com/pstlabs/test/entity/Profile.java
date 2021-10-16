package com.pstlabs.test.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class Profile {

    @Id
    @GeneratedValue
    private Long id;
    private String firstName;
    private String lastName;
    private String address;

    @OneToOne
    @JoinColumn(name = "userId")
    private User user;
}
