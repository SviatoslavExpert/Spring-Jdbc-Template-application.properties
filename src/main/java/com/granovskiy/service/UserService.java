package com.granovskiy.service;

import com.granovskiy.model.User;

public interface UserService {
    User getByUsername(String username);
}
