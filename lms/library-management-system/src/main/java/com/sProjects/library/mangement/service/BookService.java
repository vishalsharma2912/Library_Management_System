package com.sProjects.library.mangement.service;

import com.sProjects.library.mangement.DTOs.BookDTO.BookRequest;
import com.sProjects.library.mangement.DTOs.BookDTO.BookResponse;
import com.sProjects.library.mangement.Enum.Genre;
import com.sProjects.library.mangement.exceptions.BookNotFoundException;
import com.sProjects.library.mangement.model.Author;
import com.sProjects.library.mangement.model.Book;
import com.sProjects.library.mangement.repository.AuthorRepo;
import com.sProjects.library.mangement.repository.BookRepo;
import com.sProjects.library.mangement.transformers.BookTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    AuthorRepo authorRepo;
    public ResponseEntity addBook(BookRequest bookRequest) {

        Optional<Author> author=authorRepo.findById(bookRequest.getAuthorId());
        if( !author.isPresent() )
        {
            return new ResponseEntity<>("Author not found", HttpStatus.NOT_FOUND);
        }



        //bookreq -> book
        Book book= BookTransformer.bookRequestToBook(bookRequest,author.get());

        //save
        author.get().getBooks().add(book);
        authorRepo.save(author.get());
        //bookRepo.save(book);

        //book to response
        BookResponse bookResponse=BookTransformer.bookToBookRespose(book);

        return new ResponseEntity<>(bookResponse,HttpStatus.CREATED);
    }

    public BookResponse getBook(int id) {
        Optional<Book> isBook= bookRepo.findById(id);
        if(isBook.isEmpty())
            throw new BookNotFoundException("Invalid book-id !!!");

        Book book=isBook.get();

        return BookTransformer.bookToBookRespose(book);
    }

    public List<BookResponse> getByGenreAndCost(Genre genre, double cost) {

        List<Book> books= bookRepo.findByGenreAndCostHQL(genre, cost);

        //book -> response
        List<BookResponse> bookResponses=new ArrayList<>();
        for(Book book:books)
            bookResponses.add(BookTransformer.bookToBookRespose(book));


        return bookResponses;
    }
}
