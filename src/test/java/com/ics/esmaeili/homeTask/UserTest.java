package com.ics.esmaeili.homeTask;

import com.ics.esmaeili.homeTask.controller.UserController;
import com.ics.esmaeili.homeTask.dto.UserDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UserTest extends HomeTaskApplicationTests {

    @Autowired
    private  UserController userController;

    @Test
    void findAllUser() {
        ResponseEntity<Page<UserDto>> all = this.userController.findAll(1,10);
        assertTrue(all.getHeaders().size() != 0);

    }
}
