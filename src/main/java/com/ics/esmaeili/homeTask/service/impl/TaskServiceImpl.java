package com.ics.esmaeili.homeTask.service.impl;

import com.ics.esmaeili.homeTask.dto.TaskDto;
import com.ics.esmaeili.homeTask.entity.Task;
import com.ics.esmaeili.homeTask.mapper.TaskMapper;
import com.ics.esmaeili.homeTask.repository.TaskRepository;
import com.ics.esmaeili.homeTask.service.TaskService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
//    @Autowired
//    TaskRepository repository;


    private final TaskRepository repository;
    private final TaskMapper taskMapper;


    @Override
    public Page<TaskDto> findAll(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        Page<Task> tasks = repository.findAll(pageRequest);
        return  tasks.map(taskMapper::toDto);
    }

    @Override
    public TaskDto findById(int id) {
        TaskDto dto=null;
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            dto = taskMapper.toDto(task);
        }
        return dto;
    }

    @Override
    @Transactional
    public TaskDto save(TaskDto taskDto) {
        Task save = repository.save(taskMapper.toEntity(taskDto));
        return taskMapper.toDto(save);
    }


    @Override
    public void delete(int id) {
        repository.deleteById(id);
    }
}
