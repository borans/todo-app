package com.todo.todo_app.dto;

import com.todo.todo_app.model.Task;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
public class UserDto {

    private String userId;
    private String name;
    private String password;
    private String email;

    private Set<TaskDto> tasks;

    public UserDto(String userId, String name, String password, String email, Set<TaskDto> tasks) {
        this.userId = userId;
        this.name = name;
        this.password = password;
        this.email = email;
        this.tasks = tasks;
    }
}
