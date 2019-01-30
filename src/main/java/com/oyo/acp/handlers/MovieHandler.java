package com.oyo.acp.handlers;

import com.oyo.acp.Services.MovieService;
import com.oyo.bookmyshow.TMovie;
import com.oyo.bookmyshow.TMovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class MovieHandler implements TMovieService.Iface {

    @Autowired
    private MovieService movieService;

    @Override
    public boolean ping(){
        return true;
    }

    @Override
    public List<TMovie> getAllMoviesByTheatre(String theatreName){
        return movieService.getAllMoviesByTheatre(theatreName);
    }

    @Override
    public List<TMovie> getAllMovies(String city){
        return movieService.getAllMovies(city);
    }
}
