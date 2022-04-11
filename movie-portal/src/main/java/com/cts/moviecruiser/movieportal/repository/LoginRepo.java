package com.cts.moviecruiser.movieportal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.moviecruiser.movieportal.model.LoginModel;

	

@Repository
public interface LoginRepo extends JpaRepository<LoginModel, String> {
 

}
