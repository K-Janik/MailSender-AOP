package pl.springboot2.karoljanik.mailsender.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.springboot2.karoljanik.mailsender.aspect.AddMovie;
import pl.springboot2.karoljanik.mailsender.model.Movie;
import pl.springboot2.karoljanik.mailsender.service.MovieService;

import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public List<Movie> getMovies() {
        return movieService.getMovies();
    }

    @PostMapping
    @AddMovie
    public ResponseEntity<Movie> addMovie(@RequestBody Movie movie) {
        if (movieService.addMovie(movie)) {
            return new ResponseEntity<>(movie, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_EXTENDED);
    }

}
