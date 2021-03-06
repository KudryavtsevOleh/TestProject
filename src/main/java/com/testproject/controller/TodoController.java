package com.testproject.controller;

import com.testproject.bean.TodoBean;
import com.testproject.model.User;
import com.testproject.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/user")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public ModelAndView loadTodos() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        ModelAndView mav = new ModelAndView("todos");
        List<TodoBean> todos = todoService.getTodosByUserId(user.getId());
        mav.addObject("todos", todos);
        mav.addObject("isEmptyTodos", todos.isEmpty());
        return mav;
    }

    @RequestMapping(value = "/addTodo", method = RequestMethod.POST)
    @ResponseBody
    public TodoBean addNewTodo(@RequestParam(required = true) String task,
                             @RequestParam(required = true) Integer priority) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        TodoBean resultBean = todoService.saveTodoItem(task, priority, user);
        return resultBean;
    }

    @RequestMapping(value = "/changeTodoStatus", method = RequestMethod.POST)
    @ResponseBody
    public Integer changeTodoStatus(@RequestParam(required = true) Integer todoId) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        todoService.changeTodoStatus(todoId);
        Integer enableTodosCount = todoService.getTodosByUserId(user.getId()).size();
        return enableTodosCount;
    }

}
