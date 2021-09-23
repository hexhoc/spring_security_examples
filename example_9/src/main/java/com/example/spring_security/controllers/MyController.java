package com.example.spring_security.controllers;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/book/create")
    public String createBook() {
        return "create book";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("book/delete")
    public String deleteBook() {
        return "delete book";
    }

    @PreAuthorize("hasRole('ADMIN')")
    @GetMapping("/book/update")
    public String updateBook() {
        return "update book";
    }

    @PreAuthorize("hasAuthority('ROLE_USER')")
    @GetMapping("/book/read")
    public String readBook() {
        return "read book";
    }

    @GetMapping("/endpoint1")
    public String endpoint1() {
        return "hello from endpoint 1";
    }

    @GetMapping("/endpoint2")
    public String endpoint2() {
        return "hello from endpoint 2";
    }

    @GetMapping("/endpoint3")
    public String endpoint3() {
        return "hello from endpoint 3";
    }

}
