package com.example.demo.service;

import com.example.demo.dao.entity.Category;
import com.example.demo.dao.repository.CategoryRepository;
import com.example.demo.dto.CategoryDto;
import com.example.demo.exception.NotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository repo;
     public CategoryDto addCategory(CategoryDto  categoryDto){
         Category category = new Category();
         category.setCategoryName(categoryDto.getCategoryName());
         repo.save(category);
         CategoryDto categoryDto1 = new CategoryDto();
         categoryDto1.setId(category.getId());
         categoryDto1.setCategoryName(category.getCategoryName());
         return categoryDto1;
     }

     public void deleteCategory(Long id){
         Category category = repo.findById(id).orElseThrow(() -> new NotFound("categoriya tapilmadi"));
         repo.delete(category);


     }
}
