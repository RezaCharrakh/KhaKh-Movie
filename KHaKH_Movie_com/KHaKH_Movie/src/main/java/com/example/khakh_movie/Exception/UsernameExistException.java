package com.example.khakh_movie.Exception;

public class UsernameExistException extends RuntimeException{
    public UsernameExistException(String username)
    {
        super("Username '" + username + "' Already exist!");
    }
}
