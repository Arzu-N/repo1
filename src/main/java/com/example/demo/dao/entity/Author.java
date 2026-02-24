package com.example.demo.dao.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstname;
    private String surname;

    @OneToMany(mappedBy="author")
    private List<Book> books;

    @OneToMany(mappedBy="author",cascade=CascadeType.ALL)
    private List<AuthorReview> reviews;

    @UpdateTimestamp
    private LocalDate updateDate;
}
