package com.example.khakh_movie.Service;

import com.example.khakh_movie.Model.DTO.Request.*;
import com.example.khakh_movie.Model.DTO.Response.MovieModel;
import com.example.khakh_movie.Model.Movie;
import com.example.khakh_movie.Repository.MovieRepository;
import com.example.khakh_movie.Repository.PrincipalsRepository;
import com.example.khakh_movie.Repository.RateRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class MovieImplemention implements MovieService {
    MovieRepository movieRepository;
    RateRepository rateRepository;
    PrincipalsRepository principalsRepository;


    @Override
    public List<MovieModel> getMovieList() {
        List<MovieModel> movieModels = new ArrayList<>();
        movieRepository.findAll().forEach(movie -> movieModels.add(movie.movieModel()));
        return movieModels;
    }

    @Override
    public Optional rating(RateMovieRequest rateMovieRequest) {
        Movie movie = movieRepository.findByTconst(rateMovieRequest.getMovie_id());
        Double avg = Double.valueOf(movie.getRate().getAverageRating());
        Double num = Double.valueOf(movie.getRate().getNumVotes());
        Double new_avg = (avg * num + rateMovieRequest.getRate()) / num + 1;
        movie.getRate().setAverageRating(new_avg.toString());
        movie.getRate().setNumVotes(String.valueOf(num + 1));
        rateRepository.save(movie.getRate());
        return Optional.empty();
    }

    @Override
    public List<MovieModel> moviesFilteredByEndYear(EndYearFilterRequest endYearFilterRequest) {
        List<MovieModel> movieModels = new ArrayList<>();
        movieRepository.findByEndYear(endYearFilterRequest.getEndYear()).forEach(movie -> movieModels.add(movie.movieModel()));
        return movieModels;
    }

    @Override
    public List<MovieModel> moviesFilteredByGenre(GenreFilterRequest genreFilterRequest) {
        List<MovieModel> movieModels = new ArrayList<>();
        movieRepository.findByGenresContaining(genreFilterRequest.getGenre()).forEach(movie -> movieModels.add(movie.movieModel()));
        return movieModels;
    }

    @Override
    public List<MovieModel> moviesFilteredByCast(CastFilterRequest castFilterRequest) {
        List<MovieModel> movieModels = new ArrayList<>();
        principalsRepository.findByPersonPrimaryName(castFilterRequest.getCastName()).forEach(movie -> movieModels.add(movie.movieModel()));
        return movieModels;
    }

    @Override
    public List<MovieModel> movieSearchFirstBy(MovieSearchRequest movieSearchRequest) {
        List<MovieModel> movieModels = new ArrayList<>();
        movieRepository.findFirstByPrimaryTitle(movieSearchRequest.getName()).forEach(movie -> movieModels.add(movie.movieModel()));
        return movieModels;
    }


}
