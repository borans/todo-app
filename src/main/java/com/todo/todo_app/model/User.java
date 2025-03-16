package com.todo.todo_app.model;

import jakarta.persistence.Entity;
import jakarta.persistence.*;

import java.util.HashSet;
import java.util.Set;

@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String userId;
    private String name;
    private String password;
    private String email;

    @OneToMany(mappedBy = "user", fetch = FetchType.LAZY)
    private Set<Task> tasks;

    public User(String name, String password, String email) {
        this.name = name;
        this.password = password;
        this.email = email;
        this.tasks = new HashSet<>();
    }

    public String getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public Set<Task> getTasks() {
        return tasks;
    }
}
