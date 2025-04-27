package com.example.demo.Service;

import com.example.demo.persistance.Movie;
import com.example.demo.repository.MovieRepository;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private final MovieRepository movieRepository;

    public MovieService(MovieRepository movieRepository) {
        this.movieRepository = movieRepository;
    }


    public void addMovie(Movie movie) {
        movieRepository.save(movie);
    }

    //Changer cette fonction pour qu'elle change tous les arguments
    public void changeMovieById(int id, Movie movie) {
        Movie existingMovie = movieRepository.findById(id).orElseThrow(() -> new RuntimeException("Movie not found"));
        existingMovie.setTitle(movie.getTitle());
        existingMovie.setGenre(movie.getGenre());
        movieRepository.save(existingMovie);
    }

}
