package com.todo.todo_app.dto.converter;

import com.todo.todo_app.dto.UserDto;
import com.todo.todo_app.model.Task;
import com.todo.todo_app.model.User;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class UserDtoConverter {

    private final TaskDtoConverter taskDtoConverter;


    public UserDtoConverter(TaskDtoConverter taskDtoConverter) {
        this.taskDtoConverter = taskDtoConverter;
    }

    public UserDto convert(User from) {
        return new UserDto(from.getUserId(),
                from.getName(),
                from.getPassword(),
                from.getEmail(),
                Objects.requireNonNull(from.getTasks())
                        .stream()
                        .map(taskDtoConverter::convert).collect(Collectors.toSet()));
    }
}
