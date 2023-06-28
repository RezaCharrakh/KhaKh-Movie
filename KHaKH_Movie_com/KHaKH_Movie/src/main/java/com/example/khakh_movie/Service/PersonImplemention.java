package com.example.khakh_movie.Service;

import com.example.khakh_movie.Model.DTO.Response.MovieModel;
import com.example.khakh_movie.Model.DTO.Response.PersonModel;
import com.example.khakh_movie.Repository.PersonRepository;

import java.util.ArrayList;
import java.util.List;

public class PersonImplemention implements PersonService {
    PersonRepository personRepository;

    @Override
    public List<PersonModel> actorList() {
        List<PersonModel> actorList = new ArrayList<>();
        personRepository.findByPrimaryProfessionContaining("actor").forEach(person -> actorList.add(person.movieModel()));
        personRepository.findByPrimaryProfessionContaining("actress").forEach(person -> actorList.add(person.movieModel()));
        return actorList;
    }
    @Override
    public List<PersonModel> directorList() {
        List<PersonModel> directorList = new ArrayList<>();
        personRepository.findByPrimaryProfessionContaining("director").forEach(person -> directorList.add(person.movieModel()));
        return directorList;
    }
}

