package com.ics.esmaeili.homeTask.controller;

import com.ics.esmaeili.homeTask.dto.TaskDto;
import com.ics.esmaeili.homeTask.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tasks")
@RequiredArgsConstructor
public class TaskController {

    private final TaskService taskService;
    @PostMapping
    ResponseEntity<TaskDto> save(@Validated @RequestBody TaskDto taskDto){
        return ResponseEntity.ok(taskService.save(taskDto));
    }

    @GetMapping("/{taskId}")
    ResponseEntity<TaskDto> findById(@PathVariable("taskId") Integer id) {
        return ResponseEntity.ok(taskService.findById(id));
    }

    @GetMapping
    ResponseEntity<Page<TaskDto>> findAll(@RequestParam("pageNumber") Integer pageNumber , @RequestParam("pageSize") Integer pageSize) {
        return ResponseEntity.ok(taskService.findAll(pageNumber,pageSize));
    }

    @PutMapping("/{taskId}")
    ResponseEntity<TaskDto> update(@Validated @RequestBody TaskDto taskDto,@PathVariable("taskId") Integer id){
        taskDto.setId(id);
        return ResponseEntity.ok(taskService.save(taskDto));
    }

    @DeleteMapping("/{taskId}")
    ResponseEntity deleteById(@PathVariable("taskId") Integer id) {
        taskService.delete(id);
        return ResponseEntity.ok().build();
    }

}
