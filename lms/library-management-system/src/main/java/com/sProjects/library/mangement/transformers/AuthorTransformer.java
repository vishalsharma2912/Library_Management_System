package com.sProjects.library.mangement.transformers;

import com.sProjects.library.mangement.DTOs.AuthorDTO.AuthorRequest;
import com.sProjects.library.mangement.DTOs.AuthorDTO.AuthorResponse;
import com.sProjects.library.mangement.model.Author;
import com.sProjects.library.mangement.model.Book;
import lombok.experimental.UtilityClass;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@UtilityClass
public class AuthorTransformer {

    @UpdateTimestamp
    Date date;
    public static Author AuthorRequestToAuthor(AuthorRequest authorRequest)
    {

        return Author.builder()
                .name(authorRequest.getName())
                .age(authorRequest.getAge())
                .email(authorRequest.getEmail())
                .country(authorRequest.getCountry())
                .gender(authorRequest.getGender())
                .lastActivity(date)
                .build();
    }

    public static AuthorResponse AuthorToAuthorResponse(Author author)
    {
//        List<String> books=new ArrayList<>();
//        if( !( author.getBooks().isEmpty() ) )
//            for(Book book: author.getBooks())
//                books.add(book.getTitle());

        return AuthorResponse.builder()
                .name(author.getName())
                .age(author.getAge())
                .email(author.getEmail())
                .country(author.getCountry())
                .gender(author.getGender())
                .lastActivity(author.getLastActivity())
               // .books(books)
                .build();
    }
}
