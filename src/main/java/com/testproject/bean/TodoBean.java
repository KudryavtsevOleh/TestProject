package com.testproject.bean;

import com.testproject.model.Todo;

public class TodoBean {

    private Integer id;
    private String task;
    private Todo.Priority taskPriority;
    private Boolean status;

    public TodoBean(Integer id, String task, Todo.Priority taskPriority, Boolean status) {
        this.id = id;
        this.task = task;
        this.taskPriority = taskPriority;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
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
