package com.example.khakh_movie;

import com.example.khakh_movie.Model.Movie;
import com.example.khakh_movie.Model.Person;
import com.example.khakh_movie.Model.Principals;
import com.example.khakh_movie.Model.Rate;
import com.example.khakh_movie.Repository.MovieRepository;
import com.example.khakh_movie.Repository.PersonRepository;
import com.example.khakh_movie.Repository.PrincipalsRepository;
import com.example.khakh_movie.Repository.RateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class KHaKhMovieApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(KHaKhMovieApplication.class, args);
    }

    @Autowired
    PersonRepository personRepository;
	@Autowired
	MovieRepository movieRepository;
	@Autowired
	PrincipalsRepository principalsRepository;
	@Autowired
	RateRepository rateRepository;
	@Override
	public void run(String... args) throws Exception {
		Map<String, Movie > movieMap = new HashMap<>();
		Map<String, Person > personMap = new HashMap<>();
		//Persons
		File file = new File("C:\\Users\\rezac\\Downloads\\Compressed\\top200IMDB+Poster\\top200IMDB\\name.basics1-200.tsv");
		ArrayList<String[]> arrayList = new ArrayList<>(); //initializing a new ArrayList out of String[]'s
		try (BufferedReader TSVReader = new BufferedReader(new FileReader(file))) {
			String line = null;
			while ((line = TSVReader.readLine()) != null) {
				String[] lineItems = line.split("\t"); //splitting the line and adding its items in String[]
				arrayList.add(lineItems); //adding the splitted line array to the ArrayList
			}
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}
		for (int i = 0; i < arrayList.size(); i++) {
			Person person = Person.builder().nconst(arrayList.get(i)[0]).primaryName(arrayList.get(i)[1]).birthYear(arrayList.get(i)[2]).deathYear(arrayList.get(i)[3])
					.primaryProfession(arrayList.get(i)[4]).knownForTitles(arrayList.get(i)[5]).posterPath(arrayList.get(i)[6]).build();
			personRepository.save(person);
			personMap.put(arrayList.get(i)[0], person);
		}

		//Movie
		file = new File(("C:\\Users\\rezac\\Downloads\\Compressed\\top200IMDB+Poster\\top200IMDB\\title.basic.1-200.tsv"));
		arrayList.clear();
		try (BufferedReader TSVReader = new BufferedReader(new FileReader(file))) {
			String line = null;
			while ((line = TSVReader.readLine()) != null) {
				String[] lineItems = line.split("\t"); //splitting the line and adding its items in String[]
				arrayList.add(lineItems); //adding the splitted line array to the ArrayList
			}
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}
		for (int i = 0; i < arrayList.size(); i++) {
			Movie movie = Movie.builder().tconst(arrayList.get(i)[0]).titleType(arrayList.get(i)[1]).primaryTitle(arrayList.get(i)[2]).originalTitle(arrayList.get(i)[3])
					.isAdult(Boolean.valueOf(arrayList.get(i)[4])).startYear(arrayList.get(i)[5]).endYear(arrayList.get(i)[6])
					.runtimeMinutes(arrayList.get(i)[7]).genres(arrayList.get(i)[8]).posterPath(arrayList.get(i)[9]).build();
			movieRepository.save(movie);
			movieMap.put(arrayList.get(i)[0], movie);
		}

		//Principals
		file = new File(("C:\\Users\\rezac\\Downloads\\Compressed\\top200IMDB+Poster\\top200IMDB\\title.principals1-200.tsv"));
		arrayList.clear();
		try (BufferedReader TSVReader = new BufferedReader(new FileReader(file))) {
			String line = null;
			while ((line = TSVReader.readLine()) != null) {
				String[] lineItems = line.split("\t"); //splitting the line and adding its items in String[]
				arrayList.add(lineItems); //adding the splitted line array to the ArrayList
			}
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}
		for (int i = 0; i < arrayList.size(); i++) {
			Principals principals = Principals.builder().movie(movieMap.get(arrayList.get(i)[0])).ordering(arrayList.get(i)[1])
					.person(personMap.get(arrayList.get(i)[2])).category(arrayList.get(i)[3]).job(arrayList.get(i)[4]).characters(arrayList.get(i)[5]).build();
			principalsRepository.save(principals);
		}

		//Rate
		file = new File(("C:\\Users\\rezac\\Downloads\\Compressed\\top200IMDB+Poster\\top200IMDB\\title.rating.1-200.tsv"));
		arrayList.clear();
		try (BufferedReader TSVReader = new BufferedReader(new FileReader(file))) {
			String line = null;
			while ((line = TSVReader.readLine()) != null) {
				String[] lineItems = line.split("\t"); //splitting the line and adding its items in String[]
				arrayList.add(lineItems); //adding the splitted line array to the ArrayList
			}
		} catch (Exception e) {
			System.out.println("Something went wrong");
		}
		for (int i = 0; i < arrayList.size(); i++) {
			Rate rate = Rate.builder().movie(movieMap.get(arrayList.get(i)[0])).averageRating(arrayList.get(i)[1]).numVotes(arrayList.get(i)[2]).build();
			rateRepository.save(rate);
			movieMap.get(arrayList.get(i)[0]).setRate(rate);
			movieRepository.save(movieMap.get(arrayList.get(i)[0]));
		}
	}
}

