package com.oyo.acp.Services;

import com.oyo.acp.Repo.TheatreRepo;
import com.oyo.acp.models.Theatre;
import com.oyo.bookmyshow.TTheatre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TheatreService {

    @Autowired
    private TheatreRepo theatreRepo;

    public boolean ping(){
        return true;
    }

    public List<TTheatre> getAllTheatres(String city){
        List<Theatre> theatres = theatreRepo.findByCity(city);
        List<TTheatre> theatresToReturn = new ArrayList<TTheatre>();
        for(Theatre t:theatres){
            theatresToReturn.add(new TTheatre(t.getId(),t.getName(),t.getCity()));
        }
        return theatresToReturn;
    }
}
