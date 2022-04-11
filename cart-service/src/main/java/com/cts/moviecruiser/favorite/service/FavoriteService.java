package com.cts.moviecruiser.favorite.service;

import java.util.List;

public interface FavoriteService {
	public boolean addFavoriteMovie(String userId, Long movieId);
	public List<Long> getAllFavoriteMovies(String userId);
	public boolean removeFavoriteMovie(String userId, Long movieId);
}
