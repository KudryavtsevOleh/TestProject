package com.testproject.controller;

import com.testproject.bean.TodoBean;
import com.testproject.model.User;
import com.testproject.service.TodoService;
import com.testproject.service.UserService;
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

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    public ModelAndView loadTodos() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        ModelAndView mav = new ModelAndView("todos");
        User user = userService.getUserByUsernameAndPassword((String) auth.getPrincipal(), (String) auth.getCredentials());
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
        User user = userService.getUserByUsernameAndPassword((String) auth.getPrincipal(), (String) auth.getCredentials());
        TodoBean todoBean = todoService.saveTodoItem(task, priority, user);
        return todoBean;
    }

}
