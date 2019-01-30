package com.oyo.acp.handlers;

import com.oyo.acp.Services.TheatreService;
import com.oyo.acp.models.Theatre;
import com.oyo.bookmyshow.TTheatre;
import com.oyo.bookmyshow.TTheatreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
public class TheatreHandler implements TTheatreService.Iface {

    @Autowired
    private TheatreService theatreService;

    @Override
    public boolean ping(){
        return true;
    }

    @Override
    public List<TTheatre> getAllTheatres(String city){
        return theatreService.getAllTheatres(city);
    }
}
