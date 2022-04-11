package com.cts.moviecruiser.movie.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cts.moviecruiser.movie.entity.Movie;


@Repository
public interface MovieRepository extends JpaRepository<Movie,Long>{
	@Query("select m from Movie m where m.active=true and m.dateOfLaunch<=cast(current_timestamp() as date)")
	public List<Movie> getMovieListCustomer();
	
	@Query("select m from Movie m")
	public List<Movie> getMovieListAdmin();
}
