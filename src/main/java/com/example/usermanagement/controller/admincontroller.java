package com.example.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.usermanagement.entity.userentity;
import com.example.usermanagement.service.userservice;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class admincontroller {

    @Autowired
    private userservice userService;

    
    @GetMapping("/users")
    public List<userentity> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/users/{id}")
    public userentity getUser(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @PutMapping("/users/{userId}/roles/{roleId}")
    public userentity assignRole(
            @PathVariable Long userId,
            @PathVariable Long roleId)
    {
    	System.out.println("Assign Role API Called");
        return userService.assignRole(userId, roleId);
        
    }
    
    @PostMapping("/users")
    public userentity createUser(
            @Valid @RequestBody userentity user) {

        return userService.saveUser(user);
    }

    @PutMapping("/users/{id}")
    public userentity updateUser(
            @PathVariable Long id,
            @RequestBody userentity user) {

        user.setId(id);

        return userService.saveUser(user);
    }

    @DeleteMapping("/users/{id}")
    public String deleteUser(
            @PathVariable Long id) {

        userService.deleteUser(id);

        return "User Deleted";
    }
    
//    @PutMapping("/test")
//    public String test() {
//        return "PUT Working";
//    }
    
    @PostMapping("/test")
    public String test() {
        return "POST Working";
    }
}