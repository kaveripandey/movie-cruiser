package com.cts.moviecruiser.movieportal.client;

import java.util.ArrayList;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cts.moviecruiser.exceptiuon.FavoriteEmptyException;
import com.cts.moviecruiser.movieportal.model.FavoriteResponse;
import com.cts.moviecruiser.movieportal.model.Movie;



@FeignClient(name = "FAVORITE-SERVICE", url = "localhost:8080/favorites")
public interface FavoriteClientRest {
	
	
	@PostMapping("/{userId}/{movieId}")
	public ResponseEntity<FavoriteResponse> addFavoriteMovie(@PathVariable("userId")String userId, @PathVariable("movieId") Long movieId);
	
	@GetMapping("/{userId}")
	public List<Movie> getAllFavoriteMovies(@PathVariable("userId")String userId) throws FavoriteEmptyException;
	
	@DeleteMapping("/{userId}/{movieId}")
	public ResponseEntity<FavoriteResponse> removeFavoriteMovie(@PathVariable("userId")String userId, @PathVariable("movieId") Long movieId);

}
