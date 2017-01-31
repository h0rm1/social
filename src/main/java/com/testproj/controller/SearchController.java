package com.testproj.controller;

import java.util.Arrays;
import java.util.List;

import com.testproj.Actor;
import com.testproj.Movie;
import com.testproj.MovieMongoRepo;
import com.testproj.MovieService;
import com.testproj.MovieSqlRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

    @Autowired
    private MovieMongoRepo movieMongoRepo;

    @Autowired
    private MovieSqlRepo movieSqlRepo;

    @Autowired
    private MovieService movieService;

    @RequestMapping("/add")
    @ResponseBody
    public Movie addMovie(@RequestBody Movie movie) {
        try {
            movieService.addMovie(movie);
            return movie;
        } catch (Exception e) {
            return null;
        }
    }

    @RequestMapping("/addit")
    @ResponseBody
    public Movie addMovie() {
        try {
//            movieService.addMovie(movie);
            return new Movie();
        } catch (Exception e) {
            return new Movie();
        }
    }

    @RequestMapping("/{term}")
    @ResponseBody
    public List<Movie> searchMovie(@PathVariable String term) {
        return movieService.getByTitle(term);
    }

    @RequestMapping("/searchall")
    public List<Movie> searchMovie() {
        List<Movie> movies = movieService.getAll();

        return movies;
    }

    @RequestMapping("/populatemongo")
    public List<Movie> populateMongo() {
        movieMongoRepo.deleteAll();

        Movie movie1 = new Movie();
        movie1.setTitle("Title1");
        movie1.setId_movie("1");
        Actor actor1 = new Actor();
        actor1.setName("Actor1");
        actor1.setActorId("1");
        movie1.setActors(Arrays.asList(actor1));
        movieMongoRepo.save(movie1);

        Movie movie2 = new Movie();
        movie2.setTitle("Title2");
        movie2.setId_movie("2");
        Actor actor2 = new Actor();
        actor2.setName("Actor2");
        actor2.setActorId("2");
        movie2.setActors(Arrays.asList(actor2));
        movieMongoRepo.save(movie2);

        return movieMongoRepo.findAll();
    }

    @RequestMapping("/populatesql")
    public List<Movie> populateSql() {
        movieSqlRepo.deleteAll();

        Movie movie1 = new Movie();
        movie1.setTitle("Title1");
        movie1.setId_movie("1");
        Actor actor1 = new Actor();
        actor1.setName("Actor1");
        actor1.setActorId("1");
        movie1.setActors(Arrays.asList(actor1));
        movieSqlRepo.save(movie1);

        Movie movie2 = new Movie();
        movie2.setTitle("Title2");
        movie2.setId_movie("2");
        Actor actor2 = new Actor();
        actor2.setName("Actor2");
        actor2.setActorId("2");
        movie2.setActors(Arrays.asList(actor2));
        movieSqlRepo.save(movie2);

        return movieSqlRepo.findAll();
    }


    @RequestMapping("/allrepos")
    public List<Movie> allRepos() {
        List<Movie> movies = movieMongoRepo.findAll();
        movies.addAll(movieService.getAll());
        movies.addAll(movieSqlRepo.findAll());
        return movies;
    }

    @RequestMapping("/es")
    public List<Movie> elasticSearch() {
        List<Movie> all = movieService.getAll();
        return all;
    }
}
