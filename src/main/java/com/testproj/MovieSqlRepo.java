package com.testproj;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by adrian.oanca on 1/27/2017.
 */
public interface MovieSqlRepo extends JpaRepository<Movie, String> {
    List<Movie> findAll();
}
