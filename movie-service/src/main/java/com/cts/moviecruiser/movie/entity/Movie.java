package com.cts.moviecruiser.movie.entity;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
 	
@Table(name="movie")
public class Movie {
	@Id
	private Long id;
	private String title;
	@Column(name="box_office")
	private String boxOffice;
	private boolean active;
	
	@Column(name="date_of_launch")
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="dd-MM-yyyy")
	private Date dateOfLaunch;
	private String genre;
	@Column(name="has_teaser")
	private boolean hasTeaser;
	
}
