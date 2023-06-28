package com.example.khakh_movie.Exception;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException(String user)
    {
        super("User '" + user + "' not found!");
    }
}
