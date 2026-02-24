package com.example.demo.mapper;

import com.example.demo.dto.BookResponseDto;
import com.example.demo.dto.BookReviewDto;
import com.example.demo.dao.entity.Book;
import com.example.demo.dao.entity.BookReview;


public class BookMapper {
    public static BookResponseDto  toResponseDto(Book book){
        BookResponseDto bookResponseDto = new BookResponseDto();
        bookResponseDto.setId(book.getId());
        bookResponseDto.setBookName(book.getBookName());
        bookResponseDto.setStock(book.getStock());
        bookResponseDto.setPrice(book.getPrice());
        bookResponseDto.setCategoryName(book.getCategory().getCategoryName());
        bookResponseDto.setAuthorName(book.getAuthor().getFirstname()+" "+book.getAuthor().getSurname());
        bookResponseDto.setReleaseDate(book.getReleaseDate());
        if(book.getReviews()!=null){
        bookResponseDto.setReviews(book.getReviews().stream().map(BookMapper::reviewEntityToDto).toList());

    }
        return bookResponseDto;}

    public static BookReviewDto reviewEntityToDto(BookReview review){
        BookReviewDto bookReviewDto = new BookReviewDto();
        bookReviewDto.setComment(review.getComment());
        bookReviewDto.setRating(review.getRating());
        return bookReviewDto;
    }


}

