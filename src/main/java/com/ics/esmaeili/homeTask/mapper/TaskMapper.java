package com.ics.esmaeili.homeTask.mapper;

import com.ics.esmaeili.homeTask.dto.TaskDto;
import com.ics.esmaeili.homeTask.entity.Task;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskDto toDto (Task task);
    Task toEntity (TaskDto taskDto);
}
