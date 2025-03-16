package com.todo.todo_app.dto;


import jakarta.validation.constraints.NotBlank;

public class TaskCreationRequest {

    @NotBlank
    private String userId;
    private String name;
    private String description;

    public @NotBlank String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
