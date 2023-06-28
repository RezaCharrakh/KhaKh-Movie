package com.example.khakh_movie.Exception;

public class PhoneNumberExistException extends RuntimeException {
    public PhoneNumberExistException(String phoneNumber)
    {
        super("Username '" + phoneNumber + "' Already exist!");
    }
}
