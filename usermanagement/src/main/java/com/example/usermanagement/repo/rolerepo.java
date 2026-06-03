package com.example.usermanagement.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usermanagement.entity.roleentity;

public interface rolerepo extends JpaRepository<roleentity, Long> {

    Optional<roleentity> findByName(String name);
}