package com.ics.esmaeili.homeTask.mapper;

import com.ics.esmaeili.homeTask.dto.TaskDto;
import com.ics.esmaeili.homeTask.dto.UserDto;
import com.ics.esmaeili.homeTask.entity.Task;
import com.ics.esmaeili.homeTask.entity.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto toDto (User user);
    User toEntity (UserDto userDto);
}
