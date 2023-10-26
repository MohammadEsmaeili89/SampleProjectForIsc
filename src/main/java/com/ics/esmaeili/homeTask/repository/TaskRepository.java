package com.ics.esmaeili.homeTask.repository;

import com.ics.esmaeili.homeTask.entity.Task;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface TaskRepository extends CrudRepository<Task,Integer>, PagingAndSortingRepository<Task, Integer> {
}
