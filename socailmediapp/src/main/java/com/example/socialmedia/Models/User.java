package com.example.socialmedia.Models;

import java.util.*;


//Represents a User in the social media application
public class User {
    private Long id;
    private String username;
    private Set<Long> following;
    private Set<Long> followers;

    public User(Long id, String username) {
        this.id = id;
        this.username = username;
        this.followers = new HashSet<>();
        this.following = new HashSet<>();
    }

    public Long getId() { return id; }
    public String getName() { return username; }
    public Set<Long> getFollowers() { return followers; }
    public Set<Long> getFollowing() { return following; }

  }
