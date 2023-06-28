package com.example.khakh_movie.Service;

import com.example.khakh_movie.Model.DTO.Request.*;
import com.example.khakh_movie.Model.DTO.Response.MovieModel;

import java.util.List;
import java.util.Optional;

public interface MovieService {
    List<MovieModel> getMovieList();
    Optional rating(RateMovieRequest rateMovieRequest);
    List<MovieModel> moviesFilteredByEndYear(EndYearFilterRequest endYearFilterRequest);
    List<MovieModel> moviesFilteredByGenre(GenreFilterRequest genreFilterRequest);
    List<MovieModel> moviesFilteredByCast(CastFilterRequest castFilterRequest);
    List<MovieModel> movieSearchFirstBy(MovieSearchRequest movieSearchRequest);
}

