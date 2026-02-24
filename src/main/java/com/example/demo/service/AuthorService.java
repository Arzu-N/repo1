package com.example.demo.service;

import com.example.demo.dao.entity.Author;
import com.example.demo.dao.repository.AuthorRepository;
import com.example.demo.dto.AuthorDto;
import com.example.demo.exception.NotFound;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class AuthorService {
private final AuthorRepository repo;

public AuthorDto addAuthor(AuthorDto authorDto){
    Author author = new Author();
    author.setFirstname(authorDto.getFirstname());
    author.setSurname(authorDto.getSurname());
            repo.save(author);
    AuthorDto authorDto1 = new AuthorDto();
    authorDto1.setId(author.getId());
    authorDto1.setFirstname(author.getFirstname());
    authorDto1.setSurname(author.getSurname());
    return authorDto1;

}

public void deleteAuthor(Long id){
    Author author = repo.findById(id).orElseThrow(() -> new  NotFound("AuthorNotFound"));
    repo.delete(author);
}
}

