package com.example.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import com.example.usermanagement.entity.taskentity;
import com.example.usermanagement.entity.userentity;
import com.example.usermanagement.repo.taskrepo;
import com.example.usermanagement.repo.userrepo;

@RestController
@RequestMapping("/user")
public class usercontroller {

    @Autowired
    private userrepo userRepository;

    @Autowired
    private taskrepo taskRepository;

    @GetMapping("/profile")
    public userentity getProfile(Authentication authentication) {

        String email = authentication.getName();

        return userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));
    }

    @GetMapping("/tasks")
    public List<taskentity> getTasks(
            Authentication authentication) {

        String email = authentication.getName();

        userentity user = userRepository.findByEmail(email)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        return taskRepository.findByUserId(user.getId());
    }
    
    @GetMapping("/test")
    public String test() {
        return "User Working";
    }
}