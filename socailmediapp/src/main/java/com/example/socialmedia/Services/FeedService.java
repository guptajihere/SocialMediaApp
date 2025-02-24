package com.example.socialmedia.Services;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.socialmedia.Models.Post;
import com.example.socialmedia.Repository.PostRepository;
import com.example.socialmedia.Repository.UserRepository;

//Handles operations for displaying the feed to a user 
@Service
public class FeedService {
    private  PostRepository postRepository;
    private  UserRepository userRepository;

    public FeedService(PostRepository postRepository, UserRepository userRepository) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
    }

    public List<Post> getFeed(Long userId) {
        return postRepository.findAll().stream()
                .sorted(Comparator.comparing(Post::getTimestamp).reversed())
                .collect(Collectors.toList());
    }
}
