package com.testproject.service;

import com.testproject.bean.TodoBean;
import com.testproject.dao.TodoDao;
import com.testproject.model.Todo;
import com.testproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
                todo.getId(),
                todo.getTask(),
                todo.getPriority(),
                todo.getDone()
        )).collect(Collectors.toList()));
        return result;
    }

    public TodoBean saveTodoItem(String task, Integer priority, User user) {
        Todo todo = new Todo();
        fillTodoInfo(todo, task, priority, user);
        Integer savedTodoId = todoDao.saveWithGettingId(todo);
        return new TodoBean(
                savedTodoId,
                task,
                Todo.Priority.values()[priority],
                DEFAULT_TODO_STATUS
        );
    }

    private void fillTodoInfo(Todo todo, String task, Integer priority, User user) {
        todo.setTask(task);
        todo.setPriority(Todo.Priority.values()[priority]);
        todo.setUser(user);
    }

    public void changeTodoStatus(Integer todoId) {
        Todo todo = todoDao.getTodoById(todoId);
        todo.setDone(true);
        todoDao.updateTodo(todo);
    }

}
