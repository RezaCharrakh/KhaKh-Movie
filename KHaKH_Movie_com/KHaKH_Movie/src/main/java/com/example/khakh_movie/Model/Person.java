package com.example.khakh_movie.Model;

import com.example.khakh_movie.Model.DTO.Response.MovieModel;
import com.example.khakh_movie.Model.DTO.Response.PersonModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
@Data
public class Person {
    @Id
    //@GeneratedValue
    private String nconst;
    private String primaryName;
    private String birthYear;
    private String deathYear;
    private String primaryProfession;
    private String knownForTitles;
    private String posterPath;
    @OneToMany(mappedBy = "person")
    Set<Principals> principalsSet;

    public PersonModel movieModel() {
        return new PersonModel(nconst, primaryName, birthYear, deathYear, primaryProfession, knownForTitles, posterPath, principalsSet);
    }
}
