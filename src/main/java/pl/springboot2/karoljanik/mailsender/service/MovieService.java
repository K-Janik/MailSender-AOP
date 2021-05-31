package pl.springboot2.karoljanik.mailsender.service;

import org.springframework.stereotype.Service;
import pl.springboot2.karoljanik.mailsender.model.Movie;

import java.util.ArrayList;
import java.util.List;

@Service
public class MovieService {

    private static List<Movie> movies;

    public MovieService() {
        movies = new ArrayList<>();
        movies.add(new Movie("John Wick", 2014));
        movies.add(new Movie("John Wick", 2017));
        movies.add(new Movie("John Wick", 2019));
        movies.add(new Movie("Matrix", 1999));

    }

    public List<Movie> getMovies() {
        return movies;
    }

    public boolean addMovie(Movie movie) {
        return movies.add(movie);
    }
}
