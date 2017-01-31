package com.elasticrepo;

import java.util.List;

import com.testproj.Movie;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

@ComponentScan
public interface MovieElasticRepo extends ElasticsearchRepository<Movie, String> {

    List<Movie> findAll();

    List<Movie> findByTitle(String title);
}
