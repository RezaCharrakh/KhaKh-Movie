package com.example.khakh_movie.Service;

import com.example.khakh_movie.Model.DTO.Request.UserLoginRequest;
import com.example.khakh_movie.Model.DTO.Response.UserResponse;
import com.example.khakh_movie.Model.DTO.Request.UserSignupRequest;

public interface UserService {
    UserResponse userSignUp(UserSignupRequest userSignupRequest);
    UserResponse userLogIn(UserLoginRequest userLoginRequest);
}
