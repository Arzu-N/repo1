package com.example.demo.dao.repository;

import com.example.demo.dao.entity.Book;
import com.example.demo.dao.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<Category,Long> {
}
