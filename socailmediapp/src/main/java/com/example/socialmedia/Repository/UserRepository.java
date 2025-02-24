package com.example.socialmedia.Repository;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.socialmedia.Models.User;

//manages user data in-memory
@Repository
public class UserRepository {
     private final Map<Long, User> users = new HashMap<>();

    public void save(User user) {
        users.put(user.getId(), user);
    }

    public User findById(Long id) {
        return users.get(id);
    }
}
