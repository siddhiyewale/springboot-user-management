package com.example.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.usermanagement.entity.taskentity;
import com.example.usermanagement.entity.userentity;
import com.example.usermanagement.service.taskservice;
import com.example.usermanagement.service.userservice;

@RestController
@RequestMapping("/manager")
public class managercontroller {

    @Autowired
    private userservice userService;

    @Autowired
    private taskservice taskService;

    @GetMapping("/users")
    public List<userentity> getAllUsers() {

        return userService.getAllUsers();
    }

    @PostMapping("/tasks/{userId}")
    public taskentity assignTask(
            @PathVariable Long userId,
            @RequestBody taskentity task) {

        return taskService.assignTask(userId, task);
    }
    
    @GetMapping("/test")
    public String test() {
        return "Manager Working";
    }
}