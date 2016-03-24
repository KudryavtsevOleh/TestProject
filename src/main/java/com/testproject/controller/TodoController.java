package com.testproject.controller;

import com.testproject.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class TodoController {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/todos", method = RequestMethod.GET)
    @ResponseBody
    public String loadTodos() {
        return "hello";
    }

}
