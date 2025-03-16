package com.todo.todo_app.model;

import jakarta.persistence.*;

@Entity
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String taskId;
    private String taskName;
    private String taskDescription;

    private boolean doneFlag;

    @ManyToOne(fetch = FetchType.LAZY, optional = false, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Task(String taskName, String taskDescription, User user) {
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.doneFlag = false;
        this.user = user;
    }

    public void setDoneFlag(boolean doneFlag) {
        this.doneFlag = doneFlag;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
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

    public User getUser() {
        return user;
    }
}
