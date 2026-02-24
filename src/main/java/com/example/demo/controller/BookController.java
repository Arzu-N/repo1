package com.example.demo.controller;

import com.example.demo.dto.BookRequestDto;
import com.example.demo.dto.BookResponseDto;
import com.example.demo.service.BookService;
import jakarta.servlet.ServletRequest;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/book")
public class BookController {
private final BookService service;
    @GetMapping
    public ResponseEntity<List<BookResponseDto>>getBooks(ServletRequest servletRequest){
        return ResponseEntity.ok(service.getBooks());
    }

    @PostMapping
    public ResponseEntity<BookResponseDto>addBook(@RequestBody BookRequestDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addBook(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteBook(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
