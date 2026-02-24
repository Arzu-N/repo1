package com.example.demo.controller;

import com.example.demo.dao.entity.Author;
import com.example.demo.dto.AuthorDto;
import com.example.demo.dto.AuthorReviewDto;
import com.example.demo.service.AuthorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/author")
public class AuthorController {
    private final AuthorService  service;

    @PostMapping
    public ResponseEntity<AuthorDto>addAuthor(@RequestBody AuthorDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addAuthor(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteAuthor(@PathVariable Long id){
        service.deleteAuthor(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
