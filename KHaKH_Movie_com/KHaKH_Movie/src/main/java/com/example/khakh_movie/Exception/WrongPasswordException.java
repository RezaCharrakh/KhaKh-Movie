package com.example.khakh_movie.Exception;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException()
    {
        super("Password is not correct!");
    }
}
