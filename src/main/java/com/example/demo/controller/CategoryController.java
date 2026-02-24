package com.example.demo.controller;

import com.example.demo.dto.CategoryDto;
import com.example.demo.service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/category")
public class CategoryController {
private final CategoryService service;
    @PostMapping
    public ResponseEntity<CategoryDto>addCategory(@RequestBody CategoryDto dto){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.addCategory(dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void>deleteCategory(@PathVariable Long id){
        service.deleteCategory(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
