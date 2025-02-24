package com.example.socialmedia.Models;

import java.time.LocalDateTime;

//Represents a Post in the social media application.
public class Post {
    private Long id;
    private String content;
    private LocalDateTime timestamp=LocalDateTime.now();;
    private Long userId;
    private int likes;
    private int dislikes;

    public Post(Long id, Long userId, String content) {
        this.id = id;
        this.userId = userId;
        this.content = content;
        this.timestamp = LocalDateTime.now();
        this.likes = 0;
        this.dislikes = 0;
    }

    public Long getId() { return id; }
    public Long getUserId() { return userId; }
    public String getContent() { return content; }
    public LocalDateTime getTimestamp() { return timestamp; }
    public int getLikes() { return likes; }
    public int getDislikes() { return dislikes; }

    public void likePost() { this.likes++; }
    public void dislikePost() { this.dislikes++; }

   
}
