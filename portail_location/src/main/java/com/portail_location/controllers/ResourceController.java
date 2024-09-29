package com.portail_location.controllers;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;

@RestController
public class ResourceController {
    
    @GetMapping("/")
    public String getResource() {
        return "A value...";
    }
    
}
