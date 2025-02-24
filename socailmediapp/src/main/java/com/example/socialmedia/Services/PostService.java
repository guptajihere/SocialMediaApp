package com.example.socialmedia.Services;

import org.springframework.stereotype.Service;

import com.example.socialmedia.Models.Post;
import com.example.socialmedia.Repository.PostRepository;

// Handles operations for uploading a post 
@Service
public class PostService {
     private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public String uploadPost(Long userId, String content) {
        Post post = new Post(0L, userId, content);
        post = postRepository.save(post);
        return "Upload Successful with post id: " + post.getId();
    }
}
