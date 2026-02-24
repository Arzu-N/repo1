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
public class BookRequestDto {
private String bookName;
private Integer stock;
private Double price;
private Long authorId;
private Long categoryId;
private List<BookReviewDto> reviews;
private LocalDate releaseDate;
}
