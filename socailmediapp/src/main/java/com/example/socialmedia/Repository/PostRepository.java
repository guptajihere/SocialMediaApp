package com.example.socialmedia.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.example.socialmedia.Models.Post;

@Repository
public class PostRepository {
    private final Map<Long, Post> posts = new HashMap<>();
    private long postIdCounter = 1;

    public Post save(Post post) {
        post = new Post(postIdCounter++, post.getUserId(), post.getContent());
        posts.put(post.getId(), post);
        return post;
    }

    public List<Post> findAll() {
        return new ArrayList<>(posts.values());
    }
}
