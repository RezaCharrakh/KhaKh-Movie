package com.example.khakh_movie.Controller;

import com.example.khakh_movie.Model.DTO.Request.UserLoginRequest;
import com.example.khakh_movie.Model.DTO.Request.UserSignupRequest;
import com.example.khakh_movie.Model.DTO.Response.UserResponse;
import com.example.khakh_movie.Service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
public class UserController {
    private final UserService userService;

    // This program has a security problem because it does not use any authentication mechanism for requests.
    @PostMapping("/user/register")
    public ResponseEntity<UserResponse> saveUser(@RequestBody UserSignupRequest userRegisterRequest) {
        return new ResponseEntity<>(userService.userSignUp(userRegisterRequest), HttpStatus.CREATED);
    }

    @PostMapping("/user/login")
    public ResponseEntity<UserResponse> loginUser(@RequestBody UserLoginRequest userLoginRequest) {
        return new ResponseEntity<>(userService.userLogIn(userLoginRequest), HttpStatus.OK);
    }
}
