package com.example.usermanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usermanagement.entity.taskentity;
import com.example.usermanagement.entity.userentity;
import com.example.usermanagement.repo.taskrepo;
import com.example.usermanagement.repo.userrepo;

@Service
public class taskservice {

    @Autowired
    private taskrepo taskRepository;

    @Autowired
    private userrepo userRepository;

    public taskentity assignTask(Long userId, taskentity task) {

        userentity user = userRepository.findById(userId)
                .orElseThrow(() ->
                        new RuntimeException("User not found"));

        task.setUser(user);

        return taskRepository.save(task);
    }
}