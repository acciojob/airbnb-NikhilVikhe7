package com.driver.repository;

import com.driver.model.User;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class UserRepository {
    private final Map<Integer, User> users;

    public UserRepository() {
        this.users = new HashMap<>();
    }

    public void save(User user) {
        users.put(user.getaadharCardNo(), user);
    }
}
