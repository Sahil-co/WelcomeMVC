package com.cg.controllers;

import java.util.List;

import javax.validation.ConstraintViolationException;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Movie;
import com.cg.services.MovieService;

@RestController
@Validated
@RequestMapping("/movie")
public class MovieControllers {

	@Autowired
	MovieService movieService;

	private static final Logger logger = LoggerFactory.getLogger(MovieControllers.class);

	@PostMapping(value="/add", consumes=MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> addMovie(@Valid @RequestBody Movie m){
		logger.info("In the add movie controller");
		
		return movieService.addMovie(m);
	}

	@PutMapping(value = "/update", consumes = MediaType.APPLICATION_JSON_VALUE)
	public List<Movie> updateMovie(@RequestBody Movie m) {
		logger.info("In the update movie controller");

		return movieService.updateMovie(m);
	}

	@DeleteMapping("/delete/{name}")
	public List<Movie> deleteMovie(@PathVariable String name) {
		logger.info("In delete movie controller");

		return movieService.deleteMovie(name);
	}

	@GetMapping("/searchAll")
	public List<Movie> searchAllMovie() {
		logger.info("In search all movie controller");

		return movieService.searchAllMovie();
	}

	@GetMapping("/search/{genre}")
	public List<Movie> searchMovieByGenre(@PathVariable String genre) {
		logger.info("In search movie by genre controller");

		return movieService.searchMovieByGenre(genre);
	}
	
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<String> handleConstraintViolationException(ConstraintViolationException e) {
		System.out.println("In global EH..e.!!!");
		return new ResponseEntity<String>("Validation error on Path Parameter.." + e.getMessage(),
				HttpStatus.BAD_REQUEST);
	}
}
