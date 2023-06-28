package com.example.khakh_movie.Repository;

import com.example.khakh_movie.Model.Movie;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MovieRepository extends CrudRepository<Movie, String> {
    Movie findByTconst(String tconst);
    List<Movie> findByEndYear(String endYear);
    List<Movie> findByGenresContaining(String genre);
    List<Movie> findFirstByPrimaryTitle(String name);
}
