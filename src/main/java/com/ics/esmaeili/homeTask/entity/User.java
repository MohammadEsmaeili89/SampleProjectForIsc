package com.ics.esmaeili.homeTask.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@Entity
@Table(name = "TBL_USER")
@NoArgsConstructor
public class User {
    private User(String userName, String password, String email) {
        this.userName = userName;
        this.password = password;
        this.email = email;
    }

    public static User of(String userName, String password, String email) {
        return new User(userName, password, email);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotBlank
    @Column(name = "USER_NAME", unique = true)
    private String userName;

    @NotBlank
    @Column(name = "PASSWORD")
    private String password;

    @NotBlank
    @Email
    @Column(name = "EMAIL", unique = true)
    private String email;


}
