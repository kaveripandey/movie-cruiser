package com.cts.moviecruiser.favorite.entity;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Movie {

	private Long id;
	private String title;
	private String boxOffice;
	private boolean active;
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date dateOfLaunch;
	private String genre;
	private boolean hasTeaser;
	
}
