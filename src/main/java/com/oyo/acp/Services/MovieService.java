package com.oyo.acp.Services;

import com.oyo.acp.Repo.MovieRepo;
import com.oyo.acp.Repo.TheatreRepo;
import com.oyo.acp.models.Movie;
import com.oyo.acp.models.Theatre;
import com.oyo.bookmyshow.TMovie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private MovieRepo movieRepo;
    private TheatreRepo theatreRepo;

    @Autowired
    public MovieService(MovieRepo movieRepo,TheatreRepo theatreRepo){
        this.movieRepo = movieRepo;
        this.theatreRepo = theatreRepo;
    }

    List<TMovie> moviesToReturn = new ArrayList<TMovie>();

    public List<TMovie> getAllMoviesByTheatre(String theatreName){
        List<Movie> movies = movieRepo.findByTheatreName(theatreName);
        for(Movie m:movies){
            moviesToReturn.add(new TMovie(m.getId(),m.getName(),m.getTheatreName()));
        }
        return moviesToReturn;
    }

    public List<TMovie> getAllMovies(String city){
        List<Theatre> theatres = theatreRepo.findByCity(city);
        for(Theatre t:theatres){
            List<Movie> movies = movieRepo.findByTheatreName(t.getName());
            for(Movie m:movies){
                moviesToReturn.add(new TMovie(m.getId(),m.getName(),m.getTheatreName()));
            }
        }
        return moviesToReturn;
    }
}
