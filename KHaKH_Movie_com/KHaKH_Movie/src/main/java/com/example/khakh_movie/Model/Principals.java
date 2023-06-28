package com.example.khakh_movie.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class Principals {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String ordering;
    private String category;
    private String job;
    private String characters;

    @ManyToOne
    @JoinColumn(name = "movie_id")
    Movie movie;

    @ManyToOne
    @JoinColumn(name = "person_id")
    Person person;
}
