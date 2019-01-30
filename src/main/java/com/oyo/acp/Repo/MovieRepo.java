package com.oyo.acp.Repo;

import com.oyo.acp.models.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieRepo extends MongoRepository<Movie, String> {
    //@Query
    List<Movie> findByTheatreName(String theatreName);
}
