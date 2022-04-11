package com.cts.moviecruiser.movie.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cts.moviecruiser.movie.entity.Movie;
import com.cts.moviecruiser.movie.repository.MovieRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MovieServiceImpl implements MovieService {
	@Autowired
	private MovieRepository movieRepository;

	@Transactional
	public List<Movie> getMovieListCustomer() {
		log.info("Inside getMovieListCustomer serviceimpl");
		return movieRepository.getMovieListCustomer();
	}
	
	@Transactional
	public List<Movie> getMovieListAdmin() {
		log.info("Inside getMovieListAdmin serviceimpl");
		return movieRepository.getMovieListAdmin();
	}
	

	@Transactional
	public Movie getMovie(Long id) {
		log.info("Inside getMovie service");
		Optional<Movie> movie = movieRepository.findById(id);
		if (movie.isPresent()) {
			Movie obj = movie.get();
			return obj;
		} else {
			return null;
		}
	}

	@Transactional
	public boolean modifyMovie(Long id, Movie movie) {
		log.info("Inside modifyMenuItem service");
		Optional<Movie> res = movieRepository.findById(id);
		if (res.isPresent()) {
			Movie movie1=res.get();
			movie1.setTitle(movie.getTitle());
			movie1.setActive(movie.isActive());
			movie1.setBoxOffice(movie.getBoxOffice());
			movie1.setDateOfLaunch(movie.getDateOfLaunch());
			movie1.setGenre(movie.getGenre());
			movie1.setHasTeaser(movie.isHasTeaser());
			
			movieRepository.save(movie1);
			return true;
		} else {
			return false;
		}
	}


	
}
