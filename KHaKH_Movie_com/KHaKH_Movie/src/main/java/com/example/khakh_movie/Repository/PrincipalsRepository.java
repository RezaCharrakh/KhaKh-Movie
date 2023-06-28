package com.example.khakh_movie.Repository;

import com.example.khakh_movie.Model.Movie;
import com.example.khakh_movie.Model.Principals;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PrincipalsRepository extends CrudRepository<Principals, String> {
    List<Movie> findByPersonPrimaryName(String castName);
}
