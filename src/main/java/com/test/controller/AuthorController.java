package com.test.controller;

import com.test.model.Author;
import com.test.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AuthorController {

    private final AuthorService authorService;

    @Autowired
    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    @GetMapping("/authors")
    public List<Author> getAllAuthors() {
        return authorService.getAllAuthors();
    }

    @GetMapping("/author/{id}")
    public ResponseEntity<Author> getAuthorById(@PathVariable Long id) {
        return authorService.getAuthorById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/author")
    public Author createAuthor(@RequestBody Author author) {
        return authorService.createAuthor(author);
    }
}
