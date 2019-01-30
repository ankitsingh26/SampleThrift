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
        Movie m1 = new Movie("M1","T1");
        Movie m2 = new Movie("M2","T2");
        Movie m3 = new Movie("M3","T1");
        Movie m4 = new Movie("M4","T1");
        Movie m5 = new Movie("M5","T2");

//        m1.getId();
//        m2.getId();
//        m3.getId();
//        m4.getId();
//        m5.getId();

        this.movieRepo.save(m1);
        this.movieRepo.save(m2);
        this.movieRepo.save(m3);
        this.movieRepo.save(m4);
        this.movieRepo.save(m5);

        Theatre t1 = new Theatre("T1","GKP");
        Theatre t2 = new Theatre("T2","HYD");

        t1.getId();
        t2.getId();

        this.theatreRepo.save(t1);
        this.theatreRepo.save(t2);
    }

    @Test
    public void testMovie() throws Exception{
        insert();
        THttpClient httpClient = new THttpClient("http://localhost:8080/movie");
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
