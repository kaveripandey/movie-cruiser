package com.cts.moviecruiser.movieportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "LoginDetails")

@Getter
@Setter
@ToString
@Component
@AllArgsConstructor
@NoArgsConstructor
public class LoginModel {
	@Id
	   
    @Column(name="UserName")
	private String userName;
	
	@Column(name="password")
	private String password;
	@Column
	private String role;
}
