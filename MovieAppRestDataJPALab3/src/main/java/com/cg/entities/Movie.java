package com.cg.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Entity
@Table(name="movie_app")
public class Movie implements Serializable{

	@Id
	@NotBlank(message="Movie Name is required !!")
	@Pattern(regexp = "[a-zA-Z0-9]+", message="Movie name should be only alphanumeric")
	private String movieName;
	
	@NotBlank(message="Rating is required !!")
	@DecimalMin("1")
	@DecimalMax("5")
	@Pattern(regexp = "([1-5]|[1-4](\\.)[0-9])", message="Rating must be a number: e.g 2.5. Rating is on scale 1-5")
	private String rating;
	private String genre;
	
	public Movie() {
		// TODO Auto-generated constructor stub
	}

	public Movie(String movieName, String rating, String genre) {
		super();
		this.movieName = movieName;
		this.rating = rating;
		this.genre = genre;
	}

	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	@Override
	public String toString() {
		return "Movie [movieName=" + movieName + ", rating=" + rating + ", genre=" + genre + "]";
	}
	
}
