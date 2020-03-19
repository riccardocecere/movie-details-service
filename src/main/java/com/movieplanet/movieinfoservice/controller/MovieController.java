package com.movieplanet.movieinfoservice.controller;

import com.movieplanet.movieinfoservice.exception.ResourceNotFoundException;
import com.movieplanet.movieinfoservice.models.Movie;
import com.movieplanet.movieinfoservice.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/")
public class MovieController {

    @Autowired
    MovieRepository movieRepository;

    //Get all movies
    @GetMapping("/movies")
    public List<Movie> getAllMoviess() {
        return movieRepository.findAll();
    }

    //Create a new movie
    @PostMapping("/movies")
    public Movie createMovie(@Valid @RequestBody Movie movie) {
        return movieRepository.save(movie);
    }

    //Get a single movie
    @GetMapping("/movies/{id}")
    public Movie getMovieById(@PathVariable(value = "id") Long movieId) {
        return movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", movieId));
    }

    //Update a movie
    @PutMapping("/movies/{id}")
    public Movie updateMovie(@PathVariable(value = "id") Long movieId,
                           @Valid @RequestBody Movie movieDetails) {

        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", movieId));

        movie.setTitle(movieDetails.getTitle());
        movie.setActors(movieDetails.getActors());
        movie.setCategory(movieDetails.getCategory());
        movie.setCoverUrl(movieDetails.getCoverUrl());
        movie.setDuration(movieDetails.getDuration());
        movie.setPlot(movieDetails.getPlot());
        movie.setProducer(movieDetails.getProducer());
        movie.setReleaseDate(movieDetails.getReleaseDate());
        movie.setVideoUrl(movieDetails.getVideoUrl());

        Movie updatedMovie = movieRepository.save(movie);
        return updatedMovie;
    }

    //Delete a movie
    @DeleteMapping("/movies/{id}")
    public ResponseEntity<?> deleteMovie(@PathVariable(value = "id") Long movieId) {
        Movie movie = movieRepository.findById(movieId)
                .orElseThrow(() -> new ResourceNotFoundException("Movie", "id", movieId));

        movieRepository.delete(movie);

        return ResponseEntity.ok().build();
    }
}
