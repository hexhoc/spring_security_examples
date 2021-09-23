package com.example.spring_security.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @GetMapping("/book/create")
    public String createBook() {
        return "create book";
    }

    @GetMapping("book/delete")
    public String deleteBook() {
        return "delete book";
    }

    @GetMapping("/book/update")
    public String updateBook() {
        return "update book";
    }

    @GetMapping("/book/read")
    public String readBook() {
        return "read book";
    }

}
