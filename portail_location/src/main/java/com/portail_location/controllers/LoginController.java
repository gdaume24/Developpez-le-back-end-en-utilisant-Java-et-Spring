package com.portail_location.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.portail_location.services.JWTService;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;

@RestController
public class LoginController {

    public JWTService jwtService;

    public LoginController(JWTService jwtService) {
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String getToken(Authentication authentication) {
        String token = jwtService.generateToken(authentication);
        return token;
    }

    // @GetMapping("/user")   
    // public String getUser() {
    //     return "Welcome, User";
    // }

    // @GetMapping("/admin")
    // public String getAdmin() {
    //     return "Welcome, Admin";
    // }

}
