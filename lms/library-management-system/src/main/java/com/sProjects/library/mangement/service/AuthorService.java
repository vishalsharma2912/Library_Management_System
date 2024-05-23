package com.sProjects.library.mangement.service;

import com.sProjects.library.mangement.DTOs.AuthorDTO.AuthorRequest;
import com.sProjects.library.mangement.DTOs.AuthorDTO.AuthorResponse;
import com.sProjects.library.mangement.exceptions.AuthorNotFoundException;
import com.sProjects.library.mangement.model.Author;
import com.sProjects.library.mangement.repository.AuthorRepo;
import com.sProjects.library.mangement.transformers.AuthorTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class AuthorService {
    @Autowired
    AuthorRepo repo;
    public ResponseEntity addAuthor(AuthorRequest authorRequest) {
        Author author=new Author();

        //req -> model
//        author.setName(authorRequest.getName());
//        author.setAge(authorRequest.getAge());
//        author.setCountry(authorRequest.getCountry());
//        author.setEmail(authorRequest.getEmail());
        author= AuthorTransformer.AuthorRequestToAuthor(authorRequest);

        //save model
        Author savedAuthor=repo.save(author);

        //model ->response
        AuthorResponse authorResponse=AuthorTransformer.AuthorToAuthorResponse(savedAuthor);


        return new ResponseEntity(authorResponse, HttpStatus.CREATED);
    }

    public AuthorResponse getAuthor(int id) {
        Optional<Author> isAuthor= repo.findById(id);
        if(isAuthor.isEmpty())
            throw new AuthorNotFoundException("Author not found !!!");

        return AuthorTransformer.AuthorToAuthorResponse(isAuthor.get());
    }
}
