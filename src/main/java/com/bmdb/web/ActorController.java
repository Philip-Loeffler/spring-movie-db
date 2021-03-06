package com.bmdb.web;

import java.time.LocalDate;
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

import com.bmdb.business.Actor;
import com.bmdb.db.ActorRepo;

@CrossOrigin
@RestController
@RequestMapping("/actors")
public class ActorController {
// a controllewr will implement five crud methods  
// get all, get by id, post -insert, post -update, delete -delete.

	
@Autowired
private ActorRepo actorRepo;
	
@GetMapping("/")
public List<Actor> getAll() {
	//find all is doing a select all query, and literally doing everything for you. like opening connection ectect
	return actorRepo.findAll();

	}

// get movie by id
@GetMapping("/{id}")
public Optional<Actor> getById(@PathVariable int id) {
	return actorRepo.findById(id);
	}

//add a movie
@PostMapping("/")
public Actor addActor(@RequestBody Actor m) {
	 m = actorRepo.save(m);
	return m;
}

//update a movie
@PutMapping("/")
public Actor updateActor(@RequestBody Actor m) {
	 m = actorRepo.save(m);
	return m;
}

//delete a movie by id
@DeleteMapping("/{id}")
public Actor deleteActor(@PathVariable int id) {
	Optional<Actor> m = actorRepo.findById(id);
	if(m.isPresent()) {
		actorRepo.deleteById(id);
}
	else {
		System.out.println("Error- movie not found for id " + id);
	}
		return m.get();
	}

@GetMapping("/find-by-gender")
//list all actors by gender 
//using request param to pass gender 
//use request params for name value pairs
// and we use ? with it 
public List<Actor> getAllByGender(@RequestParam String gender) {
	return actorRepo.findByGender(gender);

	}

@GetMapping("/find-by-lastname-starts-with")
public List<Actor> getActirByLastName(@RequestParam String letter) {
	return actorRepo.findByLastNameLike(letter+"%");
	}

@GetMapping("/find-by-birthdate-between")
public List<Actor> getActorByDate(@RequestParam String d1, @RequestParam String d2) {
	LocalDate ld1 = LocalDate.parse(d1);
	LocalDate ld2 = LocalDate.parse(d2);
	return actorRepo.findByBirthDateBetween(ld1, ld2);


	}

}








