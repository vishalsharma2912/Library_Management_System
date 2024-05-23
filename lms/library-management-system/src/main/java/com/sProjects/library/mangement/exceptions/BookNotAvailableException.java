package com.sProjects.library.mangement.exceptions;

public class BookNotAvailableException extends RuntimeException{
    public BookNotAvailableException(String message)
    {
        super(message);
    }
}
