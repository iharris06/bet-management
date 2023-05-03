package com.zonabets.betmanagement.service;

import java.util.List;

import com.zonabets.betmanagement.model.User;

public interface UserService {
    User getUser(Long id);

    User getUser(String username);

    List<User> getUsers();

    User saveUser(User user);

    void deleteUser(Long id);
}
