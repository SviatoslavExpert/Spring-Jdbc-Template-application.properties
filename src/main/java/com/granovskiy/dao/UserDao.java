package com.granovskiy.dao;

import com.granovskiy.model.User;

public interface UserDao {
    User getByUsername(String username);
}
