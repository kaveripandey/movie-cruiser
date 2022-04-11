package com.cts.moviecruiser.favorite.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.cts.moviecruiser.favorite.entity.Favorite;

@Repository
public interface FavoriteRepository extends JpaRepository<Favorite,Long> {

	@Query("select c.movieId from Favorite c where c.userId=:userId")
	public List<Long> getAllFavoriteMovies(@Param("userId")String userId);
	
	@Modifying
	@Query(nativeQuery = true, value = "delete from favorite c where c.user_id=:userId and c.movie_id=:movieId")
	public void removeFavoriteMovie(String userId, Long movieId);
	

}
