package com.testproject.controller;

import com.google.gson.Gson;
import com.testproject.model.Todo;
import com.testproject.model.User;
import com.testproject.service.TodoService;
import com.testproject.util.ResponseBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;

@Controller
@RequestMapping("/user")
public class LoginController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = (User) auth.getPrincipal();
        if (user == null) {
            return new Gson().toJson("failed");
        }
        List<Todo> todos = todoService.getTodosByUserId(user.getId());
        String json = new Gson().toJson(todos);
        return json;
    }

}
