package com.todo.todo_app.controller;

import com.todo.todo_app.dto.UserDto;
import com.todo.todo_app.model.User;
import com.todo.todo_app.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/{userId")
    public ResponseEntity<UserDto> getUser(@Valid @PathVariable String userId) {
        return ResponseEntity.ok(userService.getUserById(userId));
    }

}
