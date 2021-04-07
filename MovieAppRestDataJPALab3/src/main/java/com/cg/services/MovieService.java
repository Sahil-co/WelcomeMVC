package com.cg.services;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.MovieAppRestDataJpaLab3Application;
import com.cg.dao.MovieDao;
import com.cg.entities.Movie;

@Service("movieService")
public class MovieService {

	@Autowired
	MovieDao movieDao;
	
	private static final Logger logger = LoggerFactory.getLogger(MovieService.class);
	
	public List<Movie> addMovie(Movie m){
		logger.info("In add movie method");
		movieDao.saveAndFlush(m);
		return movieDao.findAll();
	}
	
	public List<Movie> deleteMovie(String name){
		logger.info("In delete movie method");
		movieDao.deleteById(name);
		return movieDao.findAll();
	}
	
	public List<Movie> updateMovie(Movie m){
		logger.info("In update movie method");
		movieDao.saveAndFlush(m);
		return movieDao.findAll();
	}
	
	public List<Movie> searchAllMovie(){
		logger.info("In search all movie method");
		return movieDao.findAll();
	}
	
	public List<Movie> searchMovieByGenre(String genre){
		logger.info("In search movie by category method");
		List<Movie> list = movieDao.findAll();
		List<Movie> list1 = new ArrayList<>();
		
		for(Movie m: list) {
			if(m.getGenre().equals(genre)) {
				list1.add(m);
			}
		}
		
		return list1;
	}
}
