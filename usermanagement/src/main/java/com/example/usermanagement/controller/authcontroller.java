package com.example.usermanagement.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import com.example.usermanagement.dto.loginrequest;
import com.example.usermanagement.dto.loginresponse;
import com.example.usermanagement.security.jwtutil;

@RestController
@RequestMapping("/auth")
public class authcontroller {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private jwtutil jwtUtil;

    @PostMapping("/login")
    public ResponseEntity<loginresponse> login(
            @RequestBody loginrequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(),
                        request.getPassword()));

        String token =
                jwtUtil.generateToken(
                        request.getEmail());

        return ResponseEntity.ok(
                new loginresponse(token));
    }
}