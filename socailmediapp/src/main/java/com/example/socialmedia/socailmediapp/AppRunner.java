package com.example.socialmedia.socailmediapp;

import org.springframework.stereotype.Component;

import com.example.socialmedia.Services.FeedService;
import com.example.socialmedia.Services.PostService;
import com.example.socialmedia.Services.UserService;

import java.util.Scanner;

import org.springframework.boot.CommandLineRunner;

/* 
 Handles console input and processes user commands
 Implements CommandLineRunner to execute logic upon application startup.
*/
 @Component
public class AppRunner implements CommandLineRunner {
    
    private final UserService userService;
    private final PostService postService;
    private final FeedService feedService;

    public AppRunner(UserService userService, PostService postService, FeedService feedService) {
        this.userService = userService;
        this.postService = postService;
        this.feedService = feedService;
    }

    @Override
    public void run(String... args) {

        //preload sample data
        preloadData();
        Scanner scanner = new Scanner(System.in);
                
        while (true) {

            System.out.println("Enter Command:");
            String command = scanner.nextLine();
            String[] parts = command.split(" ", 3);
        
            switch (parts[0]) {
                case "RegisterUser":
                    System.out.println(userService.registerUser(Long.parseLong(parts[1]), parts[2]));
                    break;
                case "UploadPost":
                    System.out.println(postService.uploadPost(Long.parseLong(parts[1]), parts[2]));
                    break;
                case "InteractWithUser":
                    if (parts[1].equals("FOLLOW")) {
                        System.out.println(userService.followUser(Long.parseLong(parts[2]), Long.parseLong(parts[3])));
                    } else if (parts[1].equals("UNFOLLOW")) {
                        System.out.println(userService.unfollowUser(Long.parseLong(parts[2]), Long.parseLong(parts[3])));
                    }
                    break;
                case "ShowFeed":
                    feedService.getFeed(Long.parseLong(parts[1])).forEach(post -> 
                        System.out.println("User ID: " + post.getUserId() + " | Post: " + post.getContent())
                    );

                    break;
                default:
                    System.out.println("Invalid Command!");
                    }
                }
            }
        
    private void preloadData() {
        System.out.println("The sample data is -");

        // Create Users
        userService.registerUser(1L, "Virat");
        userService.registerUser(2L, "Messi");
        userService.registerUser(3L, "Roger");

        // Create Posts
        postService.uploadPost(1L, "My name is Virat. This is first post");
        postService.uploadPost(1L, "I am a cricketer");
        postService.uploadPost(2L, "I am Messi and I love football.");
        postService.uploadPost(3L, "Roger here! Tennis player here.");

        // Follow Users
        userService.followUser(2L, 1L); // Messi follows Virat
        userService.followUser(3L, 1L); // Roger follows Virat
        userService.followUser(1L, 3L); // Virat follows Roger

        System.out.println("Sample data loaded successfully!");
    }
}