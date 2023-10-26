package com.ics.esmaeili.homeTask.controller;

import com.ics.esmaeili.homeTask.dto.UserDto;
import com.ics.esmaeili.homeTask.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserController {
    
    private final UserService userService;
    @PostMapping
    ResponseEntity<UserDto> save(@Valid @RequestBody UserDto userDto){
        return ResponseEntity.ok(userService.save(userDto));
    }

    @GetMapping("/{userId}")
    ResponseEntity<UserDto> findById(@PathVariable("userId") Integer id) {
        return ResponseEntity.ok(userService.findById(id));
    }

    @GetMapping
    ResponseEntity<Page<UserDto>> findAll(@RequestParam("pageNumber") Integer pageNumber , @RequestParam("pageSize") Integer pageSize) {
        return ResponseEntity.ok(userService.findAll(pageNumber,pageSize));
    }

    @PutMapping("/{userId}")
    ResponseEntity<UserDto> update(@Valid @RequestBody UserDto UserDto,@PathVariable("userId") Integer id){
        UserDto.setId(id);
        return ResponseEntity.ok(userService.save(UserDto));
    }

    @DeleteMapping("/{userId}")
    ResponseEntity<Void> deleteById(@PathVariable("userId") Integer id) {
        userService.delete(id);
        return ResponseEntity.ok().build();
    }
}
