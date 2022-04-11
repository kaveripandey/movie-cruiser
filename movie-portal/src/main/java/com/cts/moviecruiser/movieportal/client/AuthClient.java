package com.cts.moviecruiser.movieportal.client;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;


import com.cts.moviecruiser.movieportal.dto.AuthenticationResponseDTO;
import com.cts.moviecruiser.movieportal.dto.ValidatingDTO;
import com.cts.moviecruiser.movieportal.model.AuthenticationRequest;
import com.cts.moviecruiser.movieportal.model.LoginModel;


@FeignClient(name = "auth-client", url = "localhost:8008/authorization")
    public interface AuthClient {


        @PostMapping(value = "/login")
        public AuthenticationResponseDTO login(@RequestBody LoginModel userlogincredentials);
        
        @GetMapping(value = "/validate")
        public ValidatingDTO getsValidity(@RequestHeader(name = "Authorization", required = true) String token);
       
        @GetMapping("/getrole/{username}")
        public AuthenticationRequest getRole(@PathVariable("username") String username);
    		
    	
        
    }
    

