package com.cts.moviecruiser.movieportal.service;
import org.springframework.stereotype.Service;

import com.cts.moviecruiser.movieportal.dto.AuthenticationResponseDTO;
import com.cts.moviecruiser.movieportal.model.LoginModel;

@Service
public interface LoginService {
LoginModel LoginSaveService(LoginModel loginModelObj);
	
	boolean getValidity(String token);

    AuthenticationResponseDTO login(LoginModel model);
    
    
   
}
