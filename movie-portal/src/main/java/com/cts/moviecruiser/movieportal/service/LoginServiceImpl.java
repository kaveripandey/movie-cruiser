package com.cts.moviecruiser.movieportal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestHeader;

import com.cts.moviecruiser.movieportal.client.AuthClient;
import com.cts.moviecruiser.movieportal.dto.AuthenticationResponseDTO;
import com.cts.moviecruiser.movieportal.model.LoginModel;
import com.cts.moviecruiser.movieportal.repository.LoginRepo;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginRepo loginRepo;
	@Autowired
    private AuthClient authClient;


	@Override
	public LoginModel LoginSaveService(LoginModel loginModelObj) {
		loginRepo.save(loginModelObj);
		return loginModelObj;
	}

	
	@Override
	public AuthenticationResponseDTO login(LoginModel loginModel) {
		log.info("LoginServiceImpl [login Method]");
		loginModel = LoginSaveService(loginModel);
		return authClient.login(loginModel);
        
	}
	
	@Override
	public boolean getValidity(@RequestHeader("Authorization")String token) {
		log.info("LoginServiceImpl [getValidity Method]");
		boolean validityStatus = authClient.getsValidity(token).isValidStatus();
		log.info("Status is ");
		System.out.println(validityStatus);
		return validityStatus;
	}
	
	
	
	}
