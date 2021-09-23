package com.example.spring_security.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @Secured("ROLE_ADMIN")
    @GetMapping("/hello")
    public String sayHello() {
        return "Hello from rest controller";
    }
}
