package com.driver.service;

import com.driver.model.User;
import com.driver.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User addUser(User user) {
        userRepository.save(user);
        return user;
    }
}
