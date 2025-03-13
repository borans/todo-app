package com.todo.todo_app.service;

import com.todo.todo_app.dto.converter.TaskDtoConverter;
import com.todo.todo_app.repository.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskService {

    private final TaskRepository taskRepository;
    private final UserService userService;
    private final TaskDtoConverter taskDtoConverter;

    public TaskService(TaskRepository taskRepository, UserService userService, TaskDtoConverter taskDtoConverter) {
        this.taskRepository = taskRepository;
        this.userService = userService;
        this.taskDtoConverter = taskDtoConverter;
    }
}
