package com.granovskiy.service;

import com.granovskiy.dao.UserDao;
import com.granovskiy.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    public User getByUsername(String username) {
        return userDao.getByUsername(username);
    }
}
