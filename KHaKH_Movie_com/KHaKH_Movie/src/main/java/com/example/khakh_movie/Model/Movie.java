package com.example.khakh_movie.Model;

import com.example.khakh_movie.Model.DTO.Response.MovieModel;
import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.List;
import java.util.Set;


@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class Movie {
    @Id
//    @GeneratedValue
    @Column(name = "id")
    private String tconst;

    private String titleType;
    private String primaryTitle;
    private String originalTitle;
    private Boolean isAdult;
    private String startYear;
    private String endYear;
    private String runtimeMinutes;
    private String genres;
    private String posterPath;

    @OneToMany(mappedBy = "movie")
    private List<Comment> comments;

    @OneToMany(mappedBy = "movie")
    Set<Principals> principalsSet;

    @OneToOne
//    @JoinColumn(name = "avg_rate", referencedColumnName = "averageRating")
    Rate rate;


    public MovieModel movieModel() {
        return new MovieModel(tconst, titleType, primaryTitle, originalTitle,
                isAdult, startYear, endYear, runtimeMinutes, genres, posterPath,
                comments, principalsSet);
    }
}
