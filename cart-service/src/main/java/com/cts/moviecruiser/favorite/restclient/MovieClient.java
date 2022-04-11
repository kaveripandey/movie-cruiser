package com.cts.moviecruiser.favorite.restclient;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.cts.moviecruiser.favorite.entity.Movie;

@FeignClient(name="MOVIE-SERVICE",url="localhost:8081")
public interface MovieClient {
	
	@GetMapping("/movies/{id}")
	public Movie getMovie(@PathVariable("id") long movieId);
}
