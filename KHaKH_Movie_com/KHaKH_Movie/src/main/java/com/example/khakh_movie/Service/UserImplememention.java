package com.example.khakh_movie.Service;

import com.example.khakh_movie.Exception.PhoneNumberExistException;
import com.example.khakh_movie.Exception.UserNotFoundException;
import com.example.khakh_movie.Exception.UsernameExistException;
import com.example.khakh_movie.Exception.WrongPasswordException;
import com.example.khakh_movie.Model.DTO.Request.UserLoginRequest;
import com.example.khakh_movie.Model.DTO.Response.UserResponse;
import com.example.khakh_movie.Model.DTO.Request.UserSignupRequest;
import com.example.khakh_movie.Model.User;
import com.example.khakh_movie.Repository.UserRepository;

import java.util.Optional;

public class UserImplememention implements UserService {
    UserRepository userRepository;


    @Override
    public UserResponse userSignUp(UserSignupRequest userSignupRequest) {
        Optional<User> usernameCheck = userRepository.findByUsername(userSignupRequest.getUsername());
        Optional<User> phoneNumberCheck = userRepository.findByPhoneNumber(userSignupRequest.getPhoneNumber());

        if (usernameCheck.isPresent()) {
            throw new UsernameExistException(userSignupRequest.getUsername());
        }
        if (phoneNumberCheck.isPresent()) {
            throw new PhoneNumberExistException(userSignupRequest.getPhoneNumber());
        }

        User newUser = User.builder().username(userSignupRequest.getUsername()).
                password(userSignupRequest.getPassword()).
                phoneNumber(userSignupRequest.getPhoneNumber()).build();

        return new UserResponse(userRepository.save(newUser).getUsername(), newUser.getId());
    }

    @Override
    public UserResponse userLogIn(UserLoginRequest userLoginRequest) {
        Optional<User> userCheck = userRepository.findByUsername(userLoginRequest.getUsername());
        if (userCheck.isEmpty()) {
            throw new UserNotFoundException(userLoginRequest.getUsername());
        }
        if (!userCheck.get().getPassword().equals(userLoginRequest.getPassword())){
            throw new WrongPasswordException();
        }
        return new UserResponse(userCheck.get().getUsername(), userCheck.get().getId());
    }
}
