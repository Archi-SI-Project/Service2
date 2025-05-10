package com.example.demo.controllers;

import com.example.demo.Service.MovieService;
import com.example.demo.persistance.Movie;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movies")
public class MovieController {

    private final MovieService movieService;

    public MovieController(MovieService movieService) {
        this.movieService = movieService;

    }
    @PreAuthorize("permitAll()")
    @PostMapping("/add")
    public void addMovie(@RequestBody Movie movie) {
        movieService.addMovie(movie);
    }
    @PreAuthorize("permitAll()")
    @PutMapping("/update/{id}")
    public void updateMovie(@PathVariable int id, @RequestBody Movie movie) {
        movieService.changeMovieById(id, movie);
    }
}
