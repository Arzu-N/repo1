package com.example.demo.dao.repository;

import com.example.demo.dao.entity.AuthorReview;
import com.example.demo.dao.entity.BookReview;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReviewRepository extends JpaRepository<BookReview,Long> {
}
