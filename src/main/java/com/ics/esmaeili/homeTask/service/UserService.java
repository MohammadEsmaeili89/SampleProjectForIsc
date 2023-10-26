package com.ics.esmaeili.homeTask.service;

import com.ics.esmaeili.homeTask.dto.TaskDto;
import com.ics.esmaeili.homeTask.dto.UserDto;
import org.springframework.data.domain.Page;

import java.util.Optional;

public interface UserService {
    Page<UserDto> findAll(int pageNumber, int pageSize) ;
    UserDto findById(int id);
    Optional<UserDto> findByUserName(String userName);
    UserDto save(UserDto userDto);
    void delete(int id);
}
