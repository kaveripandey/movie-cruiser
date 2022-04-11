//package com.cts.moviecruiser.movieportal.service;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
//import org.springframework.stereotype.Service;
//
//import com.cts.moviecruiser.movieportal.model.UserModel;
//import com.cts.moviecruiser.movieportal.repository.MovieRepo;
//
//@Service
//public class MovieService {
//
//	@Autowired
//	MovieRepo mRepo;
//	
//	public String getUserDetails(String userName) {
//		
//		UserModel auth= mRepo.findByUserName(userName);
//		return auth.getRole();
//	}
//	
//}
