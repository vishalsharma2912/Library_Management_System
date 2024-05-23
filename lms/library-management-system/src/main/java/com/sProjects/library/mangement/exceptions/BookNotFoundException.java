package com.sProjects.library.mangement.exceptions;

public class BookNotFoundException extends RuntimeException{
    public BookNotFoundException(String message)
    {
        super(message);
    }
}
