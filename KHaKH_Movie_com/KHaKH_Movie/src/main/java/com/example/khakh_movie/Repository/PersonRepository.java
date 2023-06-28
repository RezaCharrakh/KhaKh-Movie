package com.example.khakh_movie.Repository;

import com.example.khakh_movie.Model.Person;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface PersonRepository extends CrudRepository<Person, String> {
    List<Person> findByPrimaryProfessionContaining(String profession);
}
