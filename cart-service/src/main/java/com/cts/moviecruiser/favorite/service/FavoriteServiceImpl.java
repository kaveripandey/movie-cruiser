package com.cts.moviecruiser.favorite.service;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.moviecruiser.favorite.entity.Favorite;
import com.cts.moviecruiser.favorite.entity.Movie;
import com.cts.moviecruiser.favorite.repository.FavoriteRepository;
import com.cts.moviecruiser.favorite.restclient.MovieClient;
import com.cts.moviecruiser.favorite.util.DateUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class FavoriteServiceImpl implements FavoriteService {

	@Autowired
	private FavoriteRepository favoriteRepository;
	
	@Autowired
	private MovieClient movieClient;

	@Transactional
	public boolean addFavoriteMovie(String userId, Long movieId) {
		log.info("Inside addCartItem service");
		List<Long> list = this.getAllFavoriteMovies(userId);
			Favorite ct = new Favorite();
			ct.setUserId(userId);
			ct.setMovieId(movieId);
			
			Date date=new Date();
			SimpleDateFormat sdf= new SimpleDateFormat("dd/MM/yyyy");
			String str = sdf.format(date);
			Movie mi=movieClient.getMovie(movieId);
			if(mi.isActive() && ((mi.getDateOfLaunch().equals(DateUtil.convertToDate(str))) || (mi.getDateOfLaunch()).before(DateUtil.convertToDate(str)))) {
				favoriteRepository.save(ct);
				return true;
			}else {
				return false;
			}
	}

	@Transactional
	public List<Long> getAllFavoriteMovies(String userId) {
		log.info("Inside getAllFavoriteMovies service");
		return favoriteRepository.getAllFavoriteMovies(userId);
	}

	@Transactional
	public boolean removeFavoriteMovie(String userId, Long movieId) {
		log.info("Inside removeFavoriteMovie service");
		List<Long> list = this.getAllFavoriteMovies(userId);
		if (list.contains(movieId)) {
			favoriteRepository.removeFavoriteMovie(userId, movieId);
			return true;
		} else {
			return false;
		}

	}


	

}
