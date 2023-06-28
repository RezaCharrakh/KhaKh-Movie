package com.example.khakh_movie.Repository;

import com.example.khakh_movie.Model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Integer> {
    Optional<User>findByUsername(String name);
    Optional<User>findByPhoneNumber(String number);
}
