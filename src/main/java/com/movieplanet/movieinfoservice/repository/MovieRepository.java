package com.movieplanet.movieinfoservice.repository;

import com.movieplanet.movieinfoservice.models.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository  extends JpaRepository<Movie, Long> {
}
