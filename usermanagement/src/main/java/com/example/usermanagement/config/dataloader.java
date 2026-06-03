package com.example.usermanagement.config;

import java.util.Set;

import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.example.usermanagement.entity.roleentity;
import com.example.usermanagement.entity.userentity;
import com.example.usermanagement.repo.rolerepo;
import com.example.usermanagement.repo.userrepo;

@Component
public class dataloader implements CommandLineRunner {

    private final rolerepo roleRepository;
    private final userrepo userRepository;
    private final PasswordEncoder passwordEncoder;

    public dataloader(rolerepo roleRepository,
                      userrepo userRepository,
                      PasswordEncoder passwordEncoder) {

        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void run(String... args) {

        if (roleRepository.count() == 0) {

            roleentity admin = new roleentity();
            admin.setName("ADMIN");

            roleentity manager = new roleentity();
            manager.setName("MANAGER");

            roleentity user = new roleentity();
            user.setName("USER");

            roleRepository.save(admin);
            roleRepository.save(manager);
            roleRepository.save(user);

            userentity adminUser = new userentity();
            adminUser.setName("Admin");
            adminUser.setEmail("admin@gmail.com");
            adminUser.setPassword(
                    passwordEncoder.encode("Admin123"));
            adminUser.setRoles(Set.of(admin));

            userRepository.save(adminUser);
        }
    }
}