package com.example.demo.service;

import com.example.demo.dao.entity.Author;
import com.example.demo.dao.entity.AuthorReview;
import com.example.demo.dao.repository.AuthorRepository;
import com.example.demo.dao.repository.AuthorReviewRepository;
import com.example.demo.dto.AuthorReviewDto;
import com.example.demo.exception.NotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthorReviewService {
    private final AuthorReviewRepository repo;
private final AuthorRepository authorRepository;
    public AuthorReviewDto addAuthorReview(AuthorReviewDto dto){
        AuthorReview authorReview = new AuthorReview();
        Author author = authorRepository.findById(dto.getAuthorId()).orElseThrow(() -> new NotFound("Author tapilmadi"));
        authorReview.setAuthor(author);
        authorReview.setComment(dto.getComment());
        authorReview.setRating(dto.getRating());
        repo.save(authorReview);
        AuthorReviewDto authorReviewDto = new AuthorReviewDto();
        authorReviewDto.setAuthorId(authorReview.getId());
        authorReviewDto.setComment(authorReview.getComment());
        authorReviewDto.setRating(authorReview.getRating());

        return dto;
    }

    public void deleteAuthorReview(Long id){
        AuthorReview authorReview = repo.findById(id).orElseThrow(() -> new RuntimeException("AuthorNotFound"));
        repo.delete(authorReview);
    }
}
