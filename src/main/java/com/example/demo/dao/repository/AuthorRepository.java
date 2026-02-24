package com.example.demo.dao.repository;

import com.example.demo.dao.entity.Author;
import com.example.demo.dao.entity.Book;
import com.sun.source.doctree.AuthorTree;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthorRepository extends JpaRepository<Author,Long> {
}
