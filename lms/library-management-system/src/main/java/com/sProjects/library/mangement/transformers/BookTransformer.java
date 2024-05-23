package com.sProjects.library.mangement.transformers;

import com.sProjects.library.mangement.DTOs.BookDTO.BookRequest;
import com.sProjects.library.mangement.DTOs.BookDTO.BookResponse;
import com.sProjects.library.mangement.model.Author;
import com.sProjects.library.mangement.model.Book;
import com.sProjects.library.mangement.repository.AuthorRepo;
import com.sProjects.library.mangement.repository.BookRepo;
import lombok.*;
import lombok.experimental.FieldDefaults;
import lombok.experimental.UtilityClass;
import org.springframework.beans.factory.annotation.Autowired;

@UtilityClass
public class BookTransformer {
    public static Book bookRequestToBook(BookRequest bookRequest, Author author)
    {
        Book book=Book.builder()
                .author(author)
                .title(bookRequest.getTitle())
                .cost(bookRequest.getCost())
                .genre(bookRequest.getGenre())
                .noOfPages(bookRequest.getNoOfPages())
                .build();

        return book;
    }

    public static BookResponse bookToBookRespose(Book book)
    {
        BookResponse bookResponse= BookResponse.builder()
                .AuthorName(book.getAuthor().getName())
                .cost(book.getCost())
                .genre(book.getGenre())
                .title(book.getTitle())
                .noOfPages(book.getNoOfPages())
                .issued(book.isIssued())
                .build();

        return bookResponse;
    }
}
