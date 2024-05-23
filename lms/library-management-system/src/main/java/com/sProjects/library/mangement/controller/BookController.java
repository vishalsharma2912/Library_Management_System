package com.sProjects.library.mangement.controller;

import com.sProjects.library.mangement.DTOs.BookDTO.BookRequest;
import com.sProjects.library.mangement.DTOs.BookDTO.BookResponse;
import com.sProjects.library.mangement.Enum.Genre;
import com.sProjects.library.mangement.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;
    @PostMapping("/add")
    public ResponseEntity addBook(@RequestBody BookRequest bookRequest)
    {
        return bookService.addBook(bookRequest);
    }

    @GetMapping("/get")
    public BookResponse getBook(@RequestParam(name = "id")int id)
    {
        return bookService.getBook(id);
    }

    @GetMapping("/get-by-genre-and-cost")
    public List<BookResponse> getByGenreAndCost(@RequestParam(name = "genre")Genre genre, @RequestParam(name = "cost")double cost)
    {
        return bookService.getByGenreAndCost(genre,cost);
    }

    //get books with multiple queries

}
