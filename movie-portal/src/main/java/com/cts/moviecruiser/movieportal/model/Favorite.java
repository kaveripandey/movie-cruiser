package com.cts.moviecruiser.movieportal.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
@Table(name="favorite")
public class Favorite {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long cid;
	
	@Column(name="user_id")
	private Long userId;
	

	@Column(name = "movie_id")
	private Long movieId;
}
