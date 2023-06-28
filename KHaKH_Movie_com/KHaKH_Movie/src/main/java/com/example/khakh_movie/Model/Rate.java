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
public class Rate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String averageRating;
    private String numVotes;

    @OneToOne
//    @JoinColumn(name = "movie_id")
    Movie movie;

}
