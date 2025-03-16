package com.todo.todo_app.dto;

import jakarta.validation.constraints.NotBlank;

public class UserCreationRequest {

    @NotBlank
    private String name;
    @NotBlank
    private String email;
    @NotBlank
    private String password;

    public @NotBlank String getName() {
        return name;
    }

    public @NotBlank String getEmail() {
        return email;
    }

    public @NotBlank String getPassword() {
        return password;
    }
}
