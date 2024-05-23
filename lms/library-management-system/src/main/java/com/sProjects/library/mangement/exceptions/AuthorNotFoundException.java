package com.sProjects.library.mangement.exceptions;

public class AuthorNotFoundException extends RuntimeException{
    public AuthorNotFoundException(String message)
    {
        super(message);
    }
}
