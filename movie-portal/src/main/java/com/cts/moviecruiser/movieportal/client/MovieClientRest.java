package com.cts.moviecruiser.movieportal.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cts.moviecruiser.movieportal.model.Movie;
import com.cts.moviecruiser.movieportal.model.MovieResponse;



@FeignClient(name = "MOVIE-SERVICE", url = "localhost:8081/movies")
public interface MovieClientRest {
	
	
	@GetMapping
	public List<Movie> getAllMovies();
	@GetMapping("/admin")
	public List<Movie> getAllMoviesAdmin();

	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable("id") Long id);

	
	@PutMapping("/{id}")
	public ResponseEntity<MovieResponse> modifyMovie(@PathVariable("id") Long id,@RequestBody Movie movie);

}
