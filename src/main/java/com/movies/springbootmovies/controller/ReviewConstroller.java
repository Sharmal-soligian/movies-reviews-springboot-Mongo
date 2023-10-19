package com.movies.springbootmovies.controller;

import com.movies.springbootmovies.model.Review;
import com.movies.springbootmovies.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping(path = "/api/v1/reviews")
public class ReviewConstroller {

    private final ReviewService reviewService;

    @Autowired
    public ReviewConstroller(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        return new ResponseEntity<Review>(reviewService.createReview(
                payload.get("reviewBody"),
                payload.get("imdbId")),
                HttpStatus.CREATED);
    }
}
