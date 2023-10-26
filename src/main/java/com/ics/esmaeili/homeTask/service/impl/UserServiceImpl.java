package com.ics.esmaeili.homeTask.service.impl;

import com.ics.esmaeili.homeTask.dto.UserDto;
import com.ics.esmaeili.homeTask.entity.Task;
import com.ics.esmaeili.homeTask.entity.User;
import com.ics.esmaeili.homeTask.mapper.UserMapper;
import com.ics.esmaeili.homeTask.repository.UserRepository;
import com.ics.esmaeili.homeTask.service.UserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository repository;
    private final UserMapper userMapper;
    @Override
    public Page<UserDto> findAll(int pageNumber, int pageSize) {
        return null;
    }

    @Override
    public UserDto findById(int id) {
        UserDto dto =null;
        Optional<User> optionalUser = repository.findById(id);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            dto = userMapper.toDto(user);
        }
        return dto;
    }

    @Override
    public Optional<UserDto> findByUserName(String userName) {
        UserDto dto =null;
        Optional<User> optionalUser = repository.findByUserName(userName);
        if(optionalUser.isPresent()){
            User user = optionalUser.get();
            dto = userMapper.toDto(user);
        }
        return Optional.of(dto);
    }

    @Transactional
    @Override
    public UserDto save(UserDto userDto) {
        User save = repository.save(userMapper.toEntity(userDto));
        return userMapper.toDto(save);
    }

    @Override
    public void delete(int id) {

        repository.deleteById(id);
    }
}
