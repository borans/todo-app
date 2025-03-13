package com.todo.todo_app.service;

import com.todo.todo_app.dto.UserDto;
import com.todo.todo_app.dto.converter.UserDtoConverter;
import com.todo.todo_app.model.User;
import com.todo.todo_app.repository.UserRepository;
import com.todo.todo_app.exception.UserNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDtoConverter userDtoConverter;


    public UserService(UserRepository userRepository, TaskService taskService, UserDtoConverter userDtoConverter) {
        this.userRepository = userRepository;
        this.userDtoConverter = userDtoConverter;
    }

    // find a user by id. finding a user means finding a user from the repo.
    public User findUserById(String userId) {
        return userRepository.findById(userId).orElseThrow(() -> new UserNotFoundException("User Could Not Find By Id: " + userId));
    }

    // get a user by id. getting a user means getting a userdto
    public UserDto getUserById(String userId) {
        return userDtoConverter.convert(findUserById(userId));
    }

}
