package com.movies.springbootmovies.service;

import com.movies.springbootmovies.model.Movie;
import com.movies.springbootmovies.repository.MovieRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {
    private final MovieRepo movieRepo;

    @Autowired
    public MovieService(MovieRepo movieRepo) {
        this.movieRepo = movieRepo;
    }

    public List<Movie> allMovies() {
        return movieRepo.findAll();
    }

//    public Movie getMovieById(ObjectId movieId) {
//        Optional<Movie> isMovie = movieRepo.findById(movieId);
//        if (isMovie.isPresent()) {
//            return isMovie.get();
//        } else {
//            throw new IllegalStateException("No movie with this id");
//        }
//    }

    public Optional<Movie> getMovieById(String imdbId) {
        return movieRepo.findMovieByImdbId(imdbId);
    }
}
