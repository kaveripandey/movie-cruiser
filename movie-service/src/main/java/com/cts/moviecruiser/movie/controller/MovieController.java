package com.cts.moviecruiser.movie.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.moviecruiser.movie.entity.Movie;
import com.cts.moviecruiser.movie.entity.MovieResponse;
import com.cts.moviecruiser.movie.service.MovieService;

import lombok.extern.slf4j.Slf4j;


@RestController
@Slf4j
@RequestMapping("/movies")
public class MovieController {
	@Autowired
	private MovieService movieService;

	@GetMapping
	public List<Movie> getAllMovies() {
		log.info("Inside getAllMovie controller");
		return movieService.getMovieListCustomer();
	}
	@GetMapping("/admin")
	public List<Movie> getAllMoviesAdmin(){
		log.info("Inside getAllMoviesAdmin controller");
		return movieService.getMovieListAdmin();
	}

	@GetMapping("/{id}")
	public Movie getMovie(@PathVariable("id") Long id) {
		log.info("Inside getMovie controller");
		return movieService.getMovie(id);
	}

	
	@PutMapping("/{id}")
	public ResponseEntity<MovieResponse> modifyMovie(@PathVariable("id") Long id,@RequestBody Movie movie) {
		log.info("Start Modify Movie Controller");
		MovieResponse response = new MovieResponse();
		if (movieService.modifyMovie(id, movie)) {
			response.setStatus("Movie is Updated");
			return new ResponseEntity<MovieResponse>(response, HttpStatus.OK);
		} else {
			response.setStatus("Movie is not updated");
			return new ResponseEntity<MovieResponse>(response, HttpStatus.NOT_FOUND);
		}
	}
}
