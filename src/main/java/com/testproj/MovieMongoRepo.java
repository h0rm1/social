package com.testproj;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface MovieMongoRepo extends MongoRepository<Movie, String> {

     List<Movie> findAll();
}
