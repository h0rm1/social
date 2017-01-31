package com.testproj;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Entity
@Document(indexName = "sample", type = "movie")
public class Movie {

    @Id
    @javax.persistence.Id
    private String id_movie;

    private String title;

    public Movie() {
    }

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Actor> actors;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    public void setId_movie(String id_movie) {
        this.id_movie = id_movie;
    }

    public String getId_movie() {
        return id_movie;
    }

    @Override
    public String toString() {
        return String.format(
                "Movie[id=%s, title='%s']",
                id_movie, title);
    }
}
