package com.example.demo.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookResponseDto {
    private Long id;
    private String bookName;
    private Integer stock;
    private Double price;
    private String categoryName;
    private String authorName;
    private List<BookReviewDto>reviews;
    private LocalDate releaseDate;
}
