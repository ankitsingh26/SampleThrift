namespace java com.oyo.bookmyshow

typedef i32 int

struct TMovie{
    1:string id;
    2:string name;
    3:string theatreName;
}

struct TTheatre{
    1:string id;
    2:string name;
    3:string city;
}

service TMovieService{
    bool ping(),
    list<TMovie> getAllMoviesByTheatre(1:string theatreName),
    list<TMovie> getAllMovies(1:string city),

}

service TTheatreService{
    bool ping(),
    list<TTheatre> getAllTheatres(1:string city),
}
