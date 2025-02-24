package com.example.socialmedia.Services;

import org.springframework.stereotype.Service;

import com.example.socialmedia.Models.User;
import com.example.socialmedia.Repository.UserRepository;

// Handles user-related operations like registration, following, and unfollwing .
@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public String registerUser(Long id, String name) {
        if (userRepository.findById(id) != null) {
            return "User ID already exists!";
        }
        User user = new User(id, name);
        userRepository.save(user);
        return name + " Registered!!";
    }

    public String followUser(Long userId1, Long userId2) {
        User user1 = userRepository.findById(userId1);
        User user2 = userRepository.findById(userId2);

        if (user1 == null || user2 == null) {
            return "Invalid User ID!";
        }

        user1.getFollowing().add(userId2);
        user2.getFollowers().add(userId1);
        return "Followed " + user2.getName() + "!!";
    }

    public String unfollowUser(Long userId1, Long userId2) {
        User user1 = userRepository.findById(userId1);
        User user2 = userRepository.findById(userId2);

        if (user1 == null || user2 == null) {
            return "Invalid User ID!";
        }

        user1.getFollowing().remove(userId2);
        user2.getFollowers().remove(userId1);
        return "Unfollowed " + user2.getName() + "!!";
    }
}
