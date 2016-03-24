package com.testproject.model;

import javax.persistence.*;

@Entity
@Table(name = "todos")
public class Todo {

    public enum Priority {
        HIGH (1),
        MEDIUM(2),
        LOW(3);

        Integer priority;

        Priority(Integer priority) {
            this.priority = priority;
        }
    }

    @Id
    @GeneratedValue
    private Integer id;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }

    @Column(name = "task")
    private String task;
    public String getTask() {
        return task;
    }
    public void setTask(String task) {
        this.task = task;
    }

    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private Priority priority;
    public Priority getPriority() {
        return priority;
    }
    public void setPriority(Priority priority) {
        this.priority = priority;
    }

    @Column(name = "status")
    private Boolean done = false;
    public Boolean getDone() {
        return done;
    }
    public void setDone(Boolean done) {
        this.done = done;
    }

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
