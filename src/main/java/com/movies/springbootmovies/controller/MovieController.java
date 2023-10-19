package com.movies.springbootmovies.controller;

import com.movies.springbootmovies.model.Movie;
import com.movies.springbootmovies.service.MovieService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

//    With error handling
//    @GetMapping
//    public ResponseEntity<Object> getAllMovies() {
//        List<Movie> movies = movieService.allMovies();
//        if (movies.isEmpty()) {
//            return new ResponseEntity<>("No movies found", HttpStatus.NOT_FOUND);
//        } else {
//            return new ResponseEntity<>(movies, HttpStatus.OK);
//        }
//    }

//    Without error handling
    @GetMapping
    public ResponseEntity<List<Movie>> getAllMovies() {
        return new ResponseEntity<List<Movie>>(movieService.allMovies(), HttpStatus.OK);
    }

    @GetMapping(path = "{imdbId}")
    public ResponseEntity<Optional<Movie>> getMovie(@PathVariable("imdbId") String imdbId) {
        return new ResponseEntity<Optional<Movie>>(movieService.getMovieById(imdbId), HttpStatus.OK);
    }

//    Invalid id error handling
//    @GetMapping("/{movieId}")
//    public ResponseEntity<?> getMovieById(@PathVariable String movieId) {
//        try {
//            ObjectId objectId = new ObjectId(movieId);
//            Movie movie = movieService.getMovieById(objectId);
//            return ResponseEntity.ok(movie);
//        } catch (IllegalArgumentException e) {
//            return ResponseEntity.status(400).body("Invalid movie ID: " + movieId);
//        } catch (Exception e) {
//            return ResponseEntity.status(500).body("An error occurred: " + e.getMessage());
//        }
//    }
}
