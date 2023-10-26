package com.ics.esmaeili.homeTask.service;

import com.ics.esmaeili.homeTask.dto.TaskDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface TaskService {
    Page<TaskDto> findAll(int pageNumber, int pageSize) ;
    TaskDto findById(int id);
    TaskDto save(TaskDto taskDto);
    void delete(int id);
}
