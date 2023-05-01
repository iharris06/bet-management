package com.zonabets.betmanagement.service;

import com.zonabets.betmanagement.model.User;

public interface UserService {
    User getUser(Long id);

    User saveUser(User user);

    void deleteUser(Long id);
}
