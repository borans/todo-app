package com.todo.todo_app.service;

import com.todo.todo_app.dto.UserCreationRequest;
import com.todo.todo_app.dto.TaskDto;
import com.todo.todo_app.dto.UserDto;
import com.todo.todo_app.dto.converter.TaskDtoConverter;
import com.todo.todo_app.dto.converter.UserDtoConverter;
import com.todo.todo_app.model.User;
import com.todo.todo_app.repository.UserRepository;
import com.todo.todo_app.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;
    private final TaskDtoConverter taskDtoConverter;

    public UserService(UserRepository userRepository, TaskService taskService, UserDtoConverter userDtoConverter, TaskDtoConverter taskDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
        this.taskDtoConverter = taskDtoConverter;
    }

    // find a user by id. finding a user means finding a user from the repo.
    protected User findUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Could Not Find By Id: " + userId));
    }

    // get a user by id. getting a user means getting a userdto
    public UserDto getUserById(String userId) {
        return userDtoConverter.convert(findUserById(userId));
    }

    // create user
    public UserDto createUser(UserCreationRequest userCreationRequest) {
        User user = new User(userCreationRequest.getName(),
                userCreationRequest.getPassword(),
                userCreationRequest.getEmail());

        return userDtoConverter.convert(userRepository.save(user));
    }

    //get all tasks
    public List<TaskDto> getAllTasks(String userId) {
        return findUserById(userId)
                .getTasks()
                .stream()
                .map(taskDtoConverter::convert)
                .collect(Collectors.toList());
    }

    //get undone tasks
    public List<TaskDto> getUndoneTasks(String userId) {
        return getAllTasks(userId)
                .stream()
                .filter(p -> !p.isDoneFlag())
                .collect(Collectors.toList());
    }

    //get done tasks
    public List<TaskDto> getDoneTasks(String userId) {
        return getAllTasks(userId)
                .stream()
                .filter(TaskDto::isDoneFlag)
                .collect(Collectors.toList());
    }


}
