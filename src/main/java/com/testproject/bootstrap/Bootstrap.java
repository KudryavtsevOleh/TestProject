package com.testproject.bootstrap;

import com.testproject.dao.UserDao;
import com.testproject.model.Role;
import com.testproject.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;

import javax.annotation.PostConstruct;
import java.util.List;

public class Bootstrap {

    @Autowired
    private UserDao userDao;

    private final String ROLE_USER = "ROLE_USER";
    private final String USER_NAME = "user";
    private final String USER_PASSWORD = "123456";

    @PostConstruct
    public void init() {
        List<Role> existingRoles = userDao.getAllRoles();
        List<User> existingUsers = userDao.getAllUsers();
        if (CollectionUtils.isEmpty(existingUsers)) {
            User user = new User();
            Role userRole;
            user.setUsername(USER_NAME);
            user.setPassword(USER_PASSWORD);
            if (CollectionUtils.isEmpty(existingRoles)) {
                userRole = new Role();
                userRole.setName(ROLE_USER);
                userDao.saveRole(userRole);
            } else {
                userRole = userDao.getRoleByName(ROLE_USER);
            }
            user.setAuthorities(userRole);
            userDao.saveUser(user);
        }
    }

}
