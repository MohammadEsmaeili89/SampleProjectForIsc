package com.ics.esmaeili.homeTask.dto;

import com.ics.esmaeili.homeTask.entity.User;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
public class TaskDto {

    private Integer id;

    @NotBlank
    private String title;

    @NotBlank
    private String description;

    private User createdUser;
}
