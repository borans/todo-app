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


    // get all tasks of a user by userid


    // get all undone tasks of a user by userid


    // get all done tasks of a user by userid


    // create a task for a user by userid


    // get a user's task by userid and taskid


    //update a user's task by userid and taskid


    //update a user's task as done if it is undone by userid and taskid


    //update a user's task as undone if it is done by userid and taskid


    //delete a user's task by userid and taskid



}
