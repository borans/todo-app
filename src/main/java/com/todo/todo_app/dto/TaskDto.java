package com.todo.todo_app.dto;

import com.todo.todo_app.model.User;
import org.springframework.stereotype.Component;

@Component
public class TaskDto {

    private String taskId;
    private String taskName;
    private String taskDescription;

    private boolean doneFlag;

    private UserDto user;

    public TaskDto(String taskId, String taskName, String taskDescription, boolean doneFlag, UserDto user) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.doneFlag = doneFlag;
        this.user = user;
    }

    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public boolean isDoneFlag() {
        return doneFlag;
    }

    public UserDto getUser() {
        return user;
    }
}
