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


    public int addMovie(Movie movie) {
        movieRepository.save(movie);
        return movie.getId();
    }

    //Changer cette fonction pour qu'elle change tous les arguments
    public void changeMovieById(int id, Movie movie) {
        Movie existingMovie = movieRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Movie not found"));

        existingMovie.setTitle(movie.getTitle());
        existingMovie.setGenre(movie.getGenre());
        existingMovie.setDuration(movie.getDuration());
        existingMovie.setCreationDate(movie.getCreationDate());
        existingMovie.setDirector(movie.getDirector());
        existingMovie.setImage(movie.getImage());
        existingMovie.setMainActors(movie.getMainActors());
        existingMovie.setSynopsis(movie.getSynopsis());
        existingMovie.setMinAge(movie.getMinAge());
        existingMovie.setLanguage(movie.getLanguage());
        existingMovie.setSubtitleLanguage(movie.getSubtitleLanguage());

        movieRepository.save(existingMovie);
    }


    public void deleteMovieById(int id) {
        movieRepository.deleteById(id);
    }
}
