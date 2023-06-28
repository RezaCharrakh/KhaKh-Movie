package com.example.khakh_movie.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;


@Table
@Entity
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class  Comment {
    @Id
    @GeneratedValue
    private String id;

    private String commentText;
    @ManyToOne
    @JoinColumn(name = "movie_id")
    private Movie movie;



}
