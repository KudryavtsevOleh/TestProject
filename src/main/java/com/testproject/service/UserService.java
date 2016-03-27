package com.testproject.service;

import com.testproject.dao.UserDao;
import com.testproject.model.Role;
import com.testproject.model.User;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class UserService {

    @Autowired
    private UserDao userDao;

    public User getUserByUsernameAndPassword(String username, String pasword) {
        return userDao.getIdByUsernameAndPassword(username, pasword);
    }

}
