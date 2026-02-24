package com.example.demo.service;

import com.example.demo.dao.entity.Author;
import com.example.demo.dao.entity.Book;
import com.example.demo.dao.entity.BookReview;
import com.example.demo.dao.entity.Category;
import com.example.demo.dao.repository.*;
import com.example.demo.dto.BookRequestDto;
import com.example.demo.dto.BookResponseDto;
import com.example.demo.exception.NotFound;
import com.example.demo.mapper.BookMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CategoryRepository categoryRepository;
    private final AuthorReviewRepository authorReviewRepository;
    private final BookReviewRepository bookReviewRepository;

    public BookResponseDto addBook(BookRequestDto dto){

        Category category = categoryRepository.findById(dto.getCategoryId()).orElseThrow(() -> new NotFound("CategoryNotFound"));
        Author author = authorRepository.findById(dto.getAuthorId()).orElseThrow(() -> new NotFound("AuthorNotFound"));
        Book book = new Book();
        book.setBookName(dto.getBookName());
        book.setStock(dto.getStock());
        book.setPrice(dto.getPrice());
        book.setReleaseDate(dto.getReleaseDate());
        book.setCategory(category);
        book.setAuthor(author);
        if(dto.getReviews()!=null){
            book.setReviews(dto.getReviews().stream().map(r->
            {
                BookReview bookReview = new BookReview();
                bookReview.setBook(book);
                bookReview.setComment(r.getComment());
                bookReview.setRating(r.getRating());
                return bookReview;
            }).toList());

        }
 return BookMapper.toResponseDto(bookRepository.save(book));
}

public List<BookResponseDto>getBooks(){
       return bookRepository.findAll().stream().map(BookMapper::toResponseDto).toList();
}

public void delete(Long id){
    Book book = bookRepository.findById(id).orElseThrow(() -> new NotFound("BookNotFound"));
    bookRepository.delete(book);
}
}
