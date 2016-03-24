package com.testproject.bootstrap;


import com.testproject.model.Role;
import com.testproject.model.User;
import com.testproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import javax.annotation.PostConstruct;
import java.util.Arrays;

public class Bootstrap {

    @Autowired
    private UserService userService;

    @PostConstruct
    public void init() {
        Role role = new Role();
        role.setName("ROLE_USER");
//        userService.saveRole(role);

        User user = new User();
        user.setUsername("oleg");
        user.setPassword("123456");
        user.setAuthorities(role);
        userService.saveUser(user);
    }

}
