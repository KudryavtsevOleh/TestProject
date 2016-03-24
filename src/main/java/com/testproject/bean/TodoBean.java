package com.testproject.bean;

import com.testproject.model.Todo;

public class TodoBean {

    private String task;
    private Todo.Priority taskPriority;
    private Boolean status;

    public TodoBean(String task, Todo.Priority taskPriority, Boolean status) {
        this.task = task;
        this.taskPriority = taskPriority;
        this.status = status;
    }

    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }

    public Todo.Priority getTaskPriority() {
        return taskPriority;
    }
    public void setTaskPriority(Todo.Priority taskPriority) {
        this.taskPriority = taskPriority;
    }

    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
}
