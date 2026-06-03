package com.example.usermanagement.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.usermanagement.entity.userentity;

public interface userrepo extends JpaRepository<userentity, Long> {

    Optional<userentity> findByEmail(String email);

    boolean existsByEmail(String email);
}