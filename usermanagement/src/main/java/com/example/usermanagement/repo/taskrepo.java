package com.example.usermanagement.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usermanagement.entity.taskentity;

public interface taskrepo extends JpaRepository<taskentity, Long> {

    List<taskentity> findByUserId(Long userId);
}