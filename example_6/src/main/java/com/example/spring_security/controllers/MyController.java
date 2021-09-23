package com.example.spring_security.controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

    @PreAuthorize("hasAuthority('book.create')")
    @GetMapping("/book/create")
    public String createBook() {
        return "create book";
    }

    @PreAuthorize("hasAuthority('book.delete')")
    @GetMapping("book/delete")
    public String deleteBook() {
        return "delete book";
    }

    @PreAuthorize("hasAuthority('book.update')")
    @GetMapping("/book/update")
    public String updateBook() {
        return "update book";
    }

    @PreAuthorize("hasAuthority('book.read')")
    @GetMapping("/book/read")
    public String readBook() {
        return "read book";
    }

}
