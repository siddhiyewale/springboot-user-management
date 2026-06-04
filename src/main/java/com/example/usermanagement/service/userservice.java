package com.example.usermanagement.service;

import org.springframework.stereotype.Service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.example.usermanagement.entity.roleentity;
import com.example.usermanagement.entity.userentity;
import com.example.usermanagement.repo.rolerepo;
import com.example.usermanagement.repo.userrepo;

import com.example.usermanagement.exception.UserAlreadyExistsException;
import com.example.usermanagement.exception.UserNotFoundException;

@Service
public class userservice {

	 @Autowired
	    private userrepo userRepository;

	 @Autowired
	 private rolerepo roleRepository;
	 
	 public userentity assignRole(Long userId, Long roleId) {

		    userentity user = userRepository.findById(userId)
		            .orElseThrow(() ->
		                    new RuntimeException("User not found"));

		    roleentity role = roleRepository.findById(roleId)
		            .orElseThrow(() ->
		                    new RuntimeException("Role not found"));

		    user.getRoles().add(role);

		    return userRepository.save(user);
		}
	 
	    public List<userentity> getAllUsers() {
	        return userRepository.findAll();
	    }

	    public userentity getUserById(Long id) {

	        return userRepository.findById(id)
	                .orElseThrow(() ->
	                        new UserNotFoundException(
	                                "User not found"));
	    }

	    public userentity saveUser(userentity user) {

	        if(userRepository.existsByEmail(user.getEmail())) {

	            throw new UserAlreadyExistsException(
	                    "User already exists");
	        }

	        return userRepository.save(user);
	    }

	    public void deleteUser(Long id) {
	        userRepository.deleteById(id);
	    }
}
