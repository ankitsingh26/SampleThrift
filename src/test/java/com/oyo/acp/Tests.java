package com.oyo.acp;

import com.oyo.acp.Repo.MovieRepo;
import com.oyo.acp.Repo.TheatreRepo;
import com.oyo.acp.models.Movie;
import com.oyo.acp.models.Theatre;
import com.oyo.bookmyshow.TMovieService;
import com.oyo.bookmyshow.TTheatreService;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Tests {

    @Autowired
    private MovieRepo movieRepo;

    @Autowired
    private TheatreRepo theatreRepo;

    private TMovieService.Client movieClient;
    private TTheatreService.Client theatreClient;

    //@Value("${local.server.port}")
    //private int port;

    //@Before
    public void insert(){
        insertMovies();
        insertTheatres();
    }

    private void insertTheatres() {
//        ...
    }

    private void insertMovies() {
        saveInMongo("movie1", "theatre1");
    }

    private void saveInMongo(String movieName, String theatreName) {
        Movie movie = new Movie(movieName, theatreName);
        movieRepo.save(movie);
    }

    @Test
    public void testMovie() throws Exception{
        insert();
        String port = "8080";
        String uri = "/movie";
        THttpClient httpClient = new THttpClient("http://localhost:"+port+uri);
        TProtocol protocol = new TBinaryProtocol(httpClient);
        movieClient = new TMovieService.Client(protocol);

        System.out.println(movieClient.getAllMovies("GKP"));

        this.movieRepo.deleteAll();
        this.theatreRepo.deleteAll();
    }

    @AfterClass
    public static void done(){
        //movieRepo.deleteAll();
        //theatreRepo.deleteAll();
        System.out.println("done with cases");
    }
}
