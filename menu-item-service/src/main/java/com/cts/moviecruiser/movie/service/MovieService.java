package com.cts.moviecruiser.movie.service;

import java.util.List;

import com.cts.moviecruiser.movie.entity.Movie;

public interface MovieService {
	public List<Movie> getMovieListCustomer();
	public Movie getMovie(Long id);
	public boolean modifyMovie(Long id,Movie movie);
	public List<Movie> getMovieListAdmin();
}
