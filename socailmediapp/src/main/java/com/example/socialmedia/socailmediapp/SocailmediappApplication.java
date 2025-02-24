package com.example.socialmedia.socailmediapp;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

/*
  Main entry point for the Social Media Console Application.
  Uses Spring Boot to initialize all components and services.
 */
@SpringBootApplication
@ComponentScan(basePackages = {"services", "repositories", "com.example.socialmedia"})  // Ensure all components are scanned

public class SocailmediappApplication {

	public static void main(String[] args) {
		SpringApplication.run(SocailmediappApplication.class, args);
        ApplicationContext context = SpringApplication.run(SocailmediappApplication.class, args);
      
        CommandLineRunner runner = context.getBean(AppRunner.class);
        try {
            runner.run(args);
        } catch (Exception e) {
            e.printStackTrace();
        }
	}

}

