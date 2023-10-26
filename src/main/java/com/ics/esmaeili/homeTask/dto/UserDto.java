package com.ics.esmaeili.homeTask.dto;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class UserDto {
    private Integer id;

    @NotBlank
    private String userName;

    @NotBlank
    private String password;

    @NotBlank
    @Email
    private String email;


}
