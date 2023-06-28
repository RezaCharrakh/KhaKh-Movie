package com.example.khakh_movie.Model.DTO.Request;

import com.example.khakh_movie.Model.User;
import lombok.Value;

@Value
public class RateMovieRequest {
    String movie_id;
    Double rate;
    String user_id;
}
