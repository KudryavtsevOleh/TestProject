package com.testproject.service;

import com.testproject.bean.TodoBean;
import com.testproject.dao.TodoDao;
import com.testproject.dao.UserDao;
import com.testproject.model.Todo;
import com.testproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TodoService {

    @Autowired
    private TodoDao todoDao;

    private Boolean DEFAULT_TODO_STATUS = false;

    public List<TodoBean> getTodosByUserId(Integer userId) {
        List<TodoBean> result = new ArrayList<>();
        List<Todo> todos = todoDao.getTodosByUserId(userId);
        result.addAll(todos.stream().map(todo -> new TodoBean(
                todo.getTask(),
                todo.getPriority(),
                todo.getDone()
        )).collect(Collectors.toList()));
        return result;
    }

    public TodoBean saveTodoItem(String task, Integer priority, User user) {
        Todo todoItem = createTodoEntity(task, priority, user);
        todoDao.save(todoItem);
        return new TodoBean(
            task,
            Todo.Priority.values()[priority],
            DEFAULT_TODO_STATUS
        );
    }

    private Todo createTodoEntity(String task, Integer priority, User user) {
        Todo todo = new Todo();
        todo.setTask(task);
        todo.setPriority(Todo.Priority.values()[priority]);
        todo.setUser(user);
        return todo;
    }

}
