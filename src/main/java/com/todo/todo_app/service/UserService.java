package com.todo.todo_app.service;

import com.todo.todo_app.dto.converter.UserDtoConverter;
import com.todo.todo_app.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final TaskService taskService;
    private final UserDtoConverter userDtoConverter;


    public UserService(UserRepository userRepository, TaskService taskService, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.taskService = taskService;
        this.userDtoConverter = userDtoConverter;
    }
}
