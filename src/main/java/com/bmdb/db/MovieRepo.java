package com.bmdb.db;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bmdb.business.Movie;


// jpa gives you core functionality of crud functions
// the first param you are giving it the entity, so in this case it is movie
// the second param is saying that the primary key type is integer
public interface MovieRepo extends JpaRepository<Movie, Integer> {
	List<Movie> findByRating(String rating);

}
