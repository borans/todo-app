package com.todo.todo_app.service;

import com.todo.todo_app.dto.TaskCreationRequest;
import com.todo.todo_app.dto.TaskDto;
import com.todo.todo_app.dto.converter.TaskDtoConverter;
import com.todo.todo_app.exception.TaskNotFoundException;
import com.todo.todo_app.model.Task;
import com.todo.todo_app.model.User;
import com.todo.todo_app.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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


    protected Task findTask(String taskId) {
        return taskRepository.findById(taskId).orElseThrow(() -> new TaskNotFoundException("Task Could Not Find By Id: " + taskId));
    }

    // get a task by taskid
    public TaskDto getTask(String taskId) {
        return taskDtoConverter.convert(findTask(taskId));
    }

    // create a task
    public TaskDto createTask(TaskCreationRequest taskCreationRequest) {

        User ownerUser = userService.findUserById(taskCreationRequest.getUserId());

        Task task = new Task(taskCreationRequest.getName(),
                taskCreationRequest.getDescription(),
                ownerUser);

        return taskDtoConverter.convert(taskRepository.save(task));
    }

    //update task description
    public void updateTaskDescription(TaskDto taskDto) {
        Task task = findTask(taskDto.getTaskId());
        task.setTaskDescription(taskDto.getTaskDescription());

        taskRepository.save(task);
    }

    //update a task as done if it is undone
    public void updateTaskAsDone(String taskId) {
        Task task = findTask(taskId);
        task.setDoneFlag(true);

        taskRepository.save(task);
    }

    //delete a task
    public void deleteTask(String taskId) {
        taskRepository.deleteById(taskId);
    }


}
