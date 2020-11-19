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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bmdb.business.Movie;
import com.bmdb.business.User;
import com.bmdb.db.UserRepo;

@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController {
// a controllewr will implement five crud methods  
// get all, get by id, post -insert, post -update, delete -delete.

	
@Autowired
private UserRepo userRepo;
	
@GetMapping("/")
public List<User> getAll() {
	//find all is doing a select all query, and literally doing everything for you. like opening connection ectect
	return userRepo.findAll();

	}

// get movie by id
@GetMapping("/{id}")
public Optional<User> getById(@PathVariable int id) {
	return userRepo.findById(id);
	}

//add a movie
@PostMapping("/")
public User addUser(@RequestBody User m) {
	 m = userRepo.save(m);
	return m;
}

//update a movie
@PutMapping("/")
public User updateUser(@RequestBody User m) {
	 m = userRepo.save(m);
	return m;
}

//delete a movie by id
@DeleteMapping("/{id}")
public  User deleteUser(@PathVariable int id) {
	Optional<User> m = userRepo.findById(id);
	if(m.isPresent()) {
		userRepo.deleteById(id);
}
	else {
		System.out.println("Error- movie not found for id " + id);
	}
		return m.get();
	}

//@GetMapping("/find-by-ratings")
//public List<Movie> getUserByRating(@RequestParam String rating) {
//	 
//	return userRepo.findByRating(rating);
//	
//
//
//	}
}
