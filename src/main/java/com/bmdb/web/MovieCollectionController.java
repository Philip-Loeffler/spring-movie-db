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

import com.bmdb.business.MovieCollection;
import com.bmdb.business.User;
import com.bmdb.db.MovieCollectionRepo;
import com.bmdb.db.UserRepo;

@CrossOrigin
@RestController
@RequestMapping("/movie-collections")
public class MovieCollectionController {
// a controllewr will implement five crud methods  
// get all, get by id, post -insert, post -update, delete -delete.

	
@Autowired
private MovieCollectionRepo movieCollectionRepo;
@Autowired
private UserRepo userRepo;

	
@GetMapping("/")
public List<MovieCollection> getAll() {
	//find all is doing a select all query, and literally doing everything for you. like opening connection ectect
	return movieCollectionRepo.findAll();

	}

// get movie by id
@GetMapping("/{id}")
public Optional<MovieCollection> getById(@PathVariable int id) {
	return movieCollectionRepo.findById(id);
	}

//add a movie
//also update collection value in user 
//passing in an instance of a movie collection, so it is passing in a movie collection
@PostMapping("/")
public MovieCollection addMovieCollection(@RequestBody MovieCollection m) {
	 m = movieCollectionRepo.save(m);
		recalculateCollectionValue(m);
	 return m;
}

//update a movie
@PutMapping("/")
public MovieCollection updateMovieCollection(@RequestBody MovieCollection m) {
	 m = movieCollectionRepo.save(m);
		recalculateCollectionValue(m);
	return m;
}

//delete a movie by id
@DeleteMapping("/{id}")
public  MovieCollection deleteMovieCollectionr(@PathVariable int id) {
	Optional<MovieCollection> m = movieCollectionRepo.findById(id);
	if(m.isPresent()) {
		movieCollectionRepo.deleteById(id);
		recalculateCollectionValue(m.get());

}
	else {
		System.out.println("Error- movie not found for id " + id);
	}
		return m.get();
	}


public void recalculateCollectionValue(MovieCollection m) {
	double newTotal = 0.0;
	//will return a list of moviecollections for this this user 
	List<MovieCollection> mcs = movieCollectionRepo.findByUserId(m.getUser().getId());
	for(MovieCollection mc: mcs) {
		 newTotal += mc.getPurchasePrice();
	}
	//getting the user from the movie collection
	User u = m.getUser();
	u.setCollectionValue(newTotal);
	userRepo.save(u);
}
}
