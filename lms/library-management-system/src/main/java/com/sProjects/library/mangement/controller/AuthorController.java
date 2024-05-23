package com.sProjects.library.mangement.controller;

import com.sProjects.library.mangement.DTOs.AuthorDTO.AuthorResponse;
import com.sProjects.library.mangement.DTOs.AuthorDTO.AuthorRequest;
import com.sProjects.library.mangement.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public ResponseEntity addAuthor(@RequestBody AuthorRequest authorRequest)
    {
        return authorService.addAuthor(authorRequest);
    }

    @GetMapping("/get")
    public AuthorResponse getAuthor(@RequestParam(name = "id")int id)
    {
        return authorService.getAuthor(id);
    }


}
