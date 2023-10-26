package com.ics.esmaeili.homeTask.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "TBL_USER")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Column(name = "USER_NAME",unique = true)
    private String userName;

    @NotBlank
    @Column(name = "PASSWORD")
    private String password;

    @NotBlank
    @Email
    @Column(name = "EMAIL", unique = true )
    private String email;


}
