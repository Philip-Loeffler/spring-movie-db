package com.bmdb.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bmdb.business.Movie;
import com.bmdb.db.MovieRepo;

@CrossOrigin
@RestController
@RequestMapping("/movies")
public class MovieController {
// a controllewr will implement five crud methods  
// get all, get by id, post -insert, post -update, delete -delete.

	
@Autowired
private MovieRepo movieRepo;
	
@GetMapping("/")
public List<Movie> getAll() {
	//find all is doing a select all query, and literally doing everything for you. like opening connection ectect
	return movieRepo.findAll();

	}

// get movie by id
@GetMapping("/{id}")
public Optional<Movie> getById(@PathVariable int id) {
	return movieRepo.findById(id);
	}

//add a movie
@PostMapping("/")
public Movie addMovie(@RequestBody Movie m) {
	 m = movieRepo.save(m);
	return m;
}

//update a movie
@PutMapping("/")
public Movie updateMovie(@RequestBody Movie m) {
	 m = movieRepo.save(m);
	return m;
}

//delete a movie by id
@DeleteMapping("/{id}")
public  Movie deleteMovie(@PathVariable int id) {
	Optional<Movie> m = movieRepo.findById(id);
	if(m.isPresent()) {
	movieRepo.deleteById(id);
}
	else {
		System.out.println("Error- movie not found for id " + id);
	}
		return m.get();
	}
}
