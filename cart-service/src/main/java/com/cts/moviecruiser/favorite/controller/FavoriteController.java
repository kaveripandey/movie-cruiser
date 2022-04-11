package com.cts.moviecruiser.favorite.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cts.moviecruiser.favorite.entity.FavoriteResponse;
import com.cts.moviecruiser.favorite.entity.Movie;
import com.cts.moviecruiser.favorite.exception.FavoriteEmptyException;
import com.cts.moviecruiser.favorite.restclient.MovieClient;
import com.cts.moviecruiser.favorite.service.FavoriteService;

import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/favorites")
public class FavoriteController {
	
	@Autowired
	private FavoriteService favoriteService;
	
	@Autowired
	private MovieClient movieClient;
	
	@PostMapping("/{userId}/{movieId}")
	public ResponseEntity<FavoriteResponse> addFavoriteMovie(@PathVariable("userId")String userId, @PathVariable("movieId") Long movieId) {
		log.info("Inside addToFavorite controller");
		FavoriteResponse response = new FavoriteResponse();
		if (favoriteService.addFavoriteMovie(userId, movieId)) {
			response.setStatus("Movie added to favorite");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setStatus("Movie not added to favorite/movie is not present in movielist");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	@GetMapping("/{userId}")
	public List<Movie> getAllFavoriteMovies(@PathVariable("userId")String userId) throws FavoriteEmptyException{
		log.info("Inside getAllFavoriteMovies controller");
		List<Long> ids=favoriteService.getAllFavoriteMovies(userId);
		if(ids.size()==0) {
			throw new FavoriteEmptyException(" Empty");
		}
		List<Movie> movies=new ArrayList<>();
		for(long i:ids) {
			movies.add(movieClient.getMovie(i));
		}
		return movies;
	}
	
	@DeleteMapping("/{userId}/{movieId}")
	public ResponseEntity<FavoriteResponse> removeFavoriteMovie(@PathVariable("userId")String userId, @PathVariable("movieId") Long movieId) {
		log.info("Inside removeFavoriteMovie controller");
		//cartService.removeCartItem(userId, menuItemId);
		FavoriteResponse response = new FavoriteResponse();
		if (favoriteService.removeFavoriteMovie(userId, movieId)) {
			response.setStatus("Movie removed from Favorites");
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			response.setStatus("Movie not removed from favorite/movie is not present");
			return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
		}
	}
	
	
	

}
