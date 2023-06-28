package com.example.khakh_movie.Service;

import com.example.khakh_movie.Model.DTO.Response.PersonModel;

import java.util.List;

public interface PersonService {
    List<PersonModel> actorList();
    List<PersonModel> directorList();
}
