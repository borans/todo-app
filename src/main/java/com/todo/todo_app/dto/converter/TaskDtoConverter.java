package com.todo.todo_app.dto.converter;

import com.todo.todo_app.dto.TaskDto;
import com.todo.todo_app.dto.UserDto;
import com.todo.todo_app.model.Task;
import com.todo.todo_app.model.User;
import org.springframework.stereotype.Component;

@Component
public class TaskDtoConverter {

    private final UserDtoConverter userDtoConverter;

    public TaskDtoConverter(UserDtoConverter userDtoConverter) {
        this.userDtoConverter = userDtoConverter;
    }


    public TaskDto convert(Task from) {
        return new TaskDto(from.getTaskId(),
                from.getTaskName(),
                from.getTaskDescription(),
                from.isDoneFlag(),
                userDtoConverter.convert(from.getUser()));
    }
}
