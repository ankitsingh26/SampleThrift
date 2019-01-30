package com.oyo.acp.Repo;

import com.oyo.acp.models.Theatre;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TheatreRepo extends MongoRepository<Theatre, String> {
    //@Query()
    List<Theatre> findByCity(String city);
}
