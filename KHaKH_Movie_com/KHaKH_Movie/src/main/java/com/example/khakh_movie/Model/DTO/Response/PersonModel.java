package com.example.khakh_movie.Model.DTO.Response;

import com.example.khakh_movie.Model.Principals;
import lombok.Value;

import javax.persistence.OneToMany;
import java.util.Set;

@Value
public class PersonModel {
    String nconst;
    String primaryName;
    String birthYear;
    String deathYear;
    String primaryProfession;
    String knownForTitles;
    String posterPath;
    Set<Principals> principalsSet;
}
