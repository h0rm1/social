package com.testproj;

import java.util.List;

import com.elasticrepo.MovieElasticRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired
    private MovieElasticRepo repository;

    public List<Movie> getAll() {
        return repository.findAll();
    }

    public List<Movie> getByTitle(String title) {
        return repository.findByTitle(title);
    }

    public void addMovie(Movie movie) {
        repository.save(movie);
    }
}
