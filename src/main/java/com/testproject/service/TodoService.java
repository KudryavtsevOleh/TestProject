package com.testproject.service;

import com.testproject.dao.TodoDao;
import com.testproject.dao.UserDao;
import com.testproject.model.Todo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class TodoService {

    @Autowired
    private TodoDao todoDao;

    public List<Todo> getTodosByUserId(Integer userId) {
        List<Todo> todos = todoDao.getTodosByUserId(userId);
        return todos;
    }

}
