package com.example.demo.controller;

import com.example.demo.dto.AuthorReviewDto;
import com.example.demo.service.AuthorReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/author-review")
public class AuthorReviewController {
    private final AuthorReviewService service;

    @PostMapping
    public ResponseEntity<AuthorReviewDto>addAuthorReview(@RequestBody AuthorReviewDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addAuthorReview(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteAuthorReview(@PathVariable Long id){
        service.deleteAuthorReview(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
