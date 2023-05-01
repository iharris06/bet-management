package com.zonabets.betmanagement.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.zonabets.betmanagement.exception.EntityNotFoundException;
import com.zonabets.betmanagement.model.User;
import com.zonabets.betmanagement.repository.UserRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserServiceDefault implements UserService {

    UserRepository userRepository;
    BCryptPasswordEncoder bCryptPasswordEncoder;

    @Override
    public void deleteUser(Long id) {
        // TODO Auto-generated method stub

    }

    @Override
    public User getUser(Long id) {
        Optional<User> user = userRepository.findById(id);
        return unwrapUser(user, id);
    }

    @Override
    public User saveUser(User user) {
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    static User unwrapUser(Optional<User> user, Long id) {
        if (user.isPresent())
            return user.get();
        else
            throw new EntityNotFoundException(id, User.class);

    }

}
