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

import com.bmdb.business.Credit;
import com.bmdb.business.Movie;
import com.bmdb.db.CreditRepo;

@CrossOrigin
@RestController
@RequestMapping("/credits")
public class CreditController {

	
	@Autowired
	private CreditRepo creditRepo;
		
	@GetMapping("/")
	public List<Credit> getAll() {
		//find all is doing a select all query, and literally doing everything for you. like opening connection ectect
		return creditRepo.findAll();
}

	// get movie by id
	@GetMapping("/{id}")
	public Optional<Credit> getById(@PathVariable int id) {
		return creditRepo.findById(id);
		}

	@PostMapping("/")
	public Credit addCredit(@RequestBody Credit m) {
		 m = creditRepo.save(m);
		return m;
	}

	@PutMapping("/")
	public Credit updateCredit(@RequestBody Credit m) {
		 m = creditRepo.save(m);
		return m;
	}

	@DeleteMapping("/{id}")
	public  Credit deleteCredit(@PathVariable int id) {
		Optional<Credit> m = creditRepo.findById(id);
		if(m.isPresent()) {
			creditRepo.deleteById(id);
	}
		else {
			System.out.println("Error- movie not found for id " + id);
		}
			return m.get();
		}
	}


