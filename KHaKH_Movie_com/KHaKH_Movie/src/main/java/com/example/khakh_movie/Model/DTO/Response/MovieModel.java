package com.example.khakh_movie.Model.DTO.Response;

import com.example.khakh_movie.Model.Comment;
import com.example.khakh_movie.Model.Principals;
import com.example.khakh_movie.Model.Rate;
import lombok.Value;

import java.util.List;
import java.util.Set;

@Value
public class MovieModel {
    String tconst;
    String titleType;
    String primaryTitle;
    String originalTitle;
    Boolean isAdult;
    String startYear;
    String endYear;
    String runtimeMinutes;
    String genres;
    String posterPath;
    List<Comment> comments;
    Set<Principals> principalsSet;
//    Rate rate;
}
